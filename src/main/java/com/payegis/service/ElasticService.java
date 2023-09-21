package com.payegis.service;

import com.alibaba.fastjson.JSON;
import com.payegis.entity.ElasticBaseEntity;
import com.payegis.entity.ElasticUpdateInfo;
import com.payegis.excelListener.excelEntity.AddressInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.search.MultiSearchRequest;
import org.elasticsearch.action.search.MultiSearchResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.UpdateQuery;
import org.springframework.data.elasticsearch.core.query.UpdateQueryBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ElasticService {

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    private final String invokingType = "1";

    public Map<String, List<ElasticBaseEntity>> select(List<AddressInfo> addressInfoList) {
        // 执行批量查询操作
        MultiSearchRequest multiSearchRequest = new MultiSearchRequest();
        //查询条件集合，按顺序存储
        Map<Integer, Object> searchObjectMap = new HashMap<>();
        for (int i = 0; i < addressInfoList.size(); i++) {
            AddressInfo addressInfo = addressInfoList.get(i);
            String esApplyId = addressInfo.getEsApplyId();
            // 设置查询时需要包含或排除的字段（实际查询时只需要index和id）
            String[] includes = new String[]{"s_T01_CreditApplyId", "no", "s_InvokingType"};
            // 如果还有其他字段需要排除，可以在这里添加
            String[] excludes = new String[]{};
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            String queryField;
            if (addressInfo.isSpecialTreatment()) {
                queryField = "s_T01_CustomerId";
            } else {
                queryField = "s_T01_CreditApplyId";
            }

            searchSourceBuilder.query(QueryBuilders.boolQuery()
                            .must(QueryBuilders.termQuery(queryField, esApplyId)))
                    //固定条件
                    //.must(QueryBuilders.termQuery("s_InvokingType", "1"))
                    .fetchSource(includes, excludes);
            // 创建对应的 SearchRequest
            SearchRequest searchRequest = new SearchRequest();
            // 如果excel中可以解析出index，直接传入
            if (StringUtils.isNotBlank(addressInfo.getDate())) {
                searchRequest.indices("event_" + addressInfo.getDate());
            }

            searchRequest.source(searchSourceBuilder);

            //请求放入map，查询失败时打印
            searchObjectMap.put(i, searchRequest);
            // 汇总查询请求
            multiSearchRequest.add(searchRequest);
        }
        //执行批量查询操作
        ActionFuture<MultiSearchResponse> multiSearchResponseActionFuture = elasticsearchOperations
                .getClient().multiSearch(multiSearchRequest);


        MultiSearchResponse items = multiSearchResponseActionFuture.actionGet();
        log.info("===========================本次从ES中查出的数据量:{}", items.getResponses().length);
        int resultIndex = 0;
        // List<ElasticBaseEntity> updateParamList = new ArrayList<>();
        Map<String, List<ElasticBaseEntity>> updateParamMap = new HashMap<>();
        for (MultiSearchResponse.Item item : items.getResponses()) {
            SearchHits hits = item.getResponse().getHits();
            if (hits.getTotalHits() == 0) {
                Object searchCondition = searchObjectMap.get(resultIndex);
                log.error("部分数据未查询到，请检查 searchCondition:{}", searchCondition);
                continue;
            }
            List<ElasticBaseEntity> hitsEntityList = new ArrayList<>();
            String esApplyId = "";
            //遍历每一个es的响应，依次获取响应值的索引/type/id
            for (SearchHit searchHit : hits.getHits()) {
                //只保留invokingType是1的
                if (!invokingType.equals(searchHit.getSource().get("s_InvokingType"))) {
                    continue;
                }
                //这里需要将searchHit中的index/type/id传入到入参中，为下一步的批量更新指定index/type/id做准备
                ElasticBaseEntity entity = new ElasticBaseEntity();
                BeanUtils.copyProperties(searchHit, entity);
                Map<String, Object> source = searchHit.getSource();
                entity.setCreditApplyId(source.get("s_T01_CreditApplyId").toString());
                entity.setNo(String.valueOf(source.get("no")));
                entity.setInvokingType(source.get("s_InvokingType").toString());
                hitsEntityList.add(entity);
                esApplyId = searchHit.getSource().get("s_T01_CreditApplyId").toString();
            }

            updateParamMap.put(esApplyId, hitsEntityList);
            resultIndex++;
        }
        log.info("es数据解析完成：updateParamMap.size:{}=====,updateParamMap.info{}", updateParamMap.size(), JSON.toJSONString(updateParamMap));
        List<String> applyListIds = addressInfoList.stream().map(AddressInfo::getEsApplyId).collect(Collectors.toList());
        List<String> elementsNotSelect = applyListIds.stream()
                .filter(element -> !updateParamMap.containsKey(element))
                .collect(Collectors.toList());
        log.info("==================不能更新Es数据的applyId的数量是:{}=========================,内容是:{}",
                elementsNotSelect.size(), JSON.toJSONString(elementsNotSelect));
        return updateParamMap;

    }

    public void updateBatch(List<ElasticBaseEntity> updateParamList) {
        log.info("单次es更新");
        List<UpdateQuery> updateQueries = new ArrayList<>();
        updateParamList.forEach(es -> {
            Map<String, String> map = new HashMap<>();
            //拼接字段列表
            List<ElasticUpdateInfo> updateInfoList = es.getUpdateInfoList();
            updateInfoList.forEach(updateInfo -> {
                map.put(updateInfo.getFieldName(), updateInfo.getFieldValue());
            });

            UpdateQuery updateQuery = new UpdateQueryBuilder()
                    .withIndexName(es.getIndex())
                    .withId(es.getId())
                    .withType(es.getType())
                    .withUpdateRequest(new UpdateRequest().doc(map))
                    .build();
            updateQueries.add(updateQuery);
        });
        elasticsearchOperations.bulkUpdate(updateQueries);
        log.info("单次es更新结束");
    }

}
