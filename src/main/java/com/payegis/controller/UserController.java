package com.payegis.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.payegis.entity.ElasticBaseEntity;
import com.payegis.entity.User;
import com.payegis.entity.UserDetail;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.search.MultiSearchRequest;
import org.elasticsearch.action.search.MultiSearchResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/es")
@Slf4j
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @RequestMapping("/test/select")
    private void test(){

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
       // searchSourceBuilder.query(QueryBuilders.termQuery("s_T01_CreditApplyId.keyword", "AQY5f0e43f1ce52"));
        searchSourceBuilder.query(QueryBuilders.matchQuery("s_T01_CreditApplyId", "AQY"));


        SearchRequest searchRequest = new SearchRequest();
        searchRequest.source(searchSourceBuilder);
        ActionFuture<SearchResponse> actionFuture = elasticsearchOperations
                .getClient().search(searchRequest);
        SearchResponse searchResponse = actionFuture.actionGet();
        SearchHits hits = searchResponse.getHits();
        for(SearchHit hit: hits){
            System.out.println(hit);
        }

    }

    @RequestMapping("/creat/index")
    private void creatIndex() throws IOException {
       String[] applyIds = {"157g6aa26431678e18","1677562748448496299","36761eed1b438cc66g","3dg596a8g8f59ae","20230807142600853551","AQY5f0e43f1ce52","JUZIa694g861a745","157g6aa26431678e18","1677562748448496299","36761eed1b438cc66g","3dg596a8g8f59ae","20230807142600853551","AQY5f0e43f1ce52","JUZIa694g861a745","157g6aa26431678e18","1677562748448496299","36761eed1b438cc66g","3dg596a8g8f59ae","20230807142600853551","AQY5f0e43f1ce52","JUZIa694g861a745","157g6aa26431678e18","1677562748448496299","36761eed1b438cc66g","3dg596a8g8f59ae","20230807142600853551","AQY5f0e43f1ce52","JUZIa694g861a745","157g6aa26431678e18","1677562748448496299","36761eed1b438cc66g","3dg596a8g8f59ae","20230807142600853551","AQY5f0e43f1ce52","JUZIa694g861a745","157g6aa26431678e18","1677562748448496299","36761eed1b438cc66g","3dg596a8g8f59ae","20230807142600853551","AQY5f0e43f1ce52","JUZIa694g861a745","157g6aa26431678e18","1677562748448496299","36761eed1b438cc66g","3dg596a8g8f59ae","20230807142600853551","AQY5f0e43f1ce52","JUZIa694g861a745","157g6aa26431678e18","1677562748448496299","36761eed1b438cc66g","3dg596a8g8f59ae","20230807142600853551","AQY5f0e43f1ce52","JUZIa694g861a745"};
       String[] test1ApplyIds = {"000CA202308150000045038","000CA202308150000289867","000CA202308300000028014","000CA202308300000024019","000CA202308150000045010","000CA202308040000043030","000CA202308150000045038","000CA202308150000045038","000CA202308150000289867","000CA202308300000028014","000CA202308300000024019","000CA202308150000045010","000CA202308040000043030","000CA202308150000045038","000CA202308150000045038","000CA202308150000289867","000CA202308300000028014","000CA202308300000024019","000CA202308150000045010","000CA202308040000043030","000CA202308150000045038","000CA202308150000045038","000CA202308150000289867","000CA202308300000028014","000CA202308300000024019","000CA202308150000045010","000CA202308040000043030","000CA202308150000045038","000CA202308150000045038","000CA202308150000289867","000CA202308300000028014","000CA202308300000024019","000CA202308150000045010","000CA202308040000043030","000CA202308150000045038","000CA202308150000045038","000CA202308150000289867","000CA202308300000028014","000CA202308300000024019","000CA202308150000045010","000CA202308040000043030","000CA202308150000045038","000CA202308150000045038","000CA202308150000289867","000CA202308300000028014","000CA202308300000024019","000CA202308150000045010","000CA202308040000043030","000CA202308150000045038","000CA202308150000045038","000CA202308150000289867","000CA202308300000028014","000CA202308300000024019","000CA202308150000045010","000CA202308040000043030","000CA202308150000045038"};
        List<User> dataList = new ArrayList<>();
        Integer i = 0;
        for(String id : test1ApplyIds){
            User user = new User();
            user.setId(String.valueOf(i++));
            user.setName("");
            user.setApplyId(id);
            dataList.add(user);
        }
        List<IndexQuery> indexQueries = convertData(dataList,"test1","_doc");
        elasticsearchTemplate.bulkIndex(indexQueries);
        log.info("bulkIndex counter : " + indexQueries.size());
        indexQueries.clear();
        dataList.clear();
        elasticsearchTemplate.refresh("test");


    }
    private List<IndexQuery> convertData(List<User> dataList,String indexName,String indexType){
        List<IndexQuery> queries = new ArrayList<>();
        for (User esEntity : dataList) {
            IndexQuery indexQuery = new IndexQuery();
            indexQuery.setId(esEntity.getId());
            indexQuery.setSource(JSONObject.toJSONString(esEntity));
            indexQuery.setIndexName(indexName);
            indexQuery.setType(indexType);
            queries.add(indexQuery);
        }
        return queries;
    }



    @RequestMapping("/select")
    private void add() throws IOException {

        String[] ids = {"1","2","5"};



        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.termsQuery("id", ids));


        SearchRequest searchRequest = new SearchRequest();
        searchRequest.source(searchSourceBuilder);
        ActionFuture<SearchResponse> actionFuture = elasticsearchOperations
                .getClient().search(searchRequest);
        SearchResponse searchResponse = actionFuture.actionGet();
        SearchHits hits = searchResponse.getHits();
        for(SearchHit hit: hits){
            System.out.println(hit);
        }

    }
    @RequestMapping("/update")
    public void select() throws IOException {

        //SearchRequest
        List<User> userList = new ArrayList<>();
        User user2 = new User();
        user2.setId("1");
        User user1 = new User();
        user1.setId("2");
        User user3 = new User();
        user3.setId("5");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        // 执行批量查询操作
        MultiSearchRequest multiSearchRequest = new MultiSearchRequest();
        //todo 查询前需要按照applyId对请求进行聚合后再汇总
        //查询条件集合，按顺序存储
        Map<Integer,Object> searchObjectMap = new HashMap<>();
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);

            // 设置查询时需要包含或排除的字段（实际查询时只需要index和id）
            String[] includes = new String[] {"userDetail_1","name"};
            String[] excludes = new String[] {};  // 如果还有其他字段需要排除，可以在这里添加
            // todo 构建查询条件
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            searchSourceBuilder.query(QueryBuilders.boolQuery()
                    .must(QueryBuilders.termQuery("id", user.getId())))
                    .fetchSource(includes,excludes);
            //.must(QueryBuilders.termQuery("name", user.getName()))
            // 创建对应的 SearchRequest
            SearchRequest searchRequest = new SearchRequest();
            searchRequest.source(searchSourceBuilder);

            //请求放入map，查询失败时打印
            searchObjectMap.put(i,searchRequest);
            // 汇总查询请求
            multiSearchRequest.add(searchRequest);
        }
        //执行批量查询操作 todo 需要确定最大的查询数量
        ActionFuture<MultiSearchResponse> multiSearchResponseActionFuture = elasticsearchOperations
                .getClient().multiSearch(multiSearchRequest);


        MultiSearchResponse items = multiSearchResponseActionFuture.actionGet();

        for (MultiSearchResponse.Item item : items.getResponses()) {
            SearchHits hits = item.getResponse().getHits();
            for(SearchHit searchHit: hits.getHits()){
                System.out.println("==================="+searchHit.getSource());
                //这里需要将searchHit中的索引/type/id传入到入参中，为下一步的批量更新指定索引/type/id做准备
                UserDetail userDetail1 = JSON.parseObject(searchHit.getSource().get("userDetail_1").toString(), UserDetail.class);
            }
        }
        int resultIndex = 0;
        //组装下一步的更新参数
        List<ElasticBaseEntity> updateParamList = new ArrayList<>();
        for (MultiSearchResponse.Item item : items.getResponses()) {

            SearchHits hits = item.getResponse().getHits();
            if(hits.getTotalHits() == 0){
                Object searchCondition = searchObjectMap.get(resultIndex);
                logger.error("部分数据未查询到，请检查 searchCondition:{}",searchCondition);
                continue;
            }
            //正常来说，不允许单个条件查出多条数据
            if(hits.getTotalHits() > 1){
                Object searchCondition = searchObjectMap.get(resultIndex);
                logger.error("单个条件查出两条数据，请检查 searchCondition:{}",searchCondition);
            }
            //遍历每一个es的响应，依次获取响应值的索引/type/id
            for(SearchHit searchHit: hits.getHits()){
                //这里需要将searchHit中的索引/type/id传入到入参中，为下一步的批量更新指定索引/type/id做准备
                System.out.println(searchHit.getIndex()+searchHit.getType()+searchHit.getId());
                ElasticBaseEntity entity = new ElasticBaseEntity();
                BeanUtils.copyProperties(searchHit,entity);
                updateParamList.add(entity);
            }
            resultIndex++;
        }
        UserDetail userDetail = new UserDetail();
        userDetail.setDetailId("1");
        userDetail.setDetailName("我是detailName");
        userDetail.setDetailOp("ooppssd");
        //todo 更新前需要再次聚合
        List<UpdateQuery> updateQueries = new ArrayList<>();

                updateParamList.forEach(es -> {
                    UpdateQuery updateQuery = new UpdateQueryBuilder()
                            .withIndexName(es.getIndex())
                            .withId(es.getId())
                            .withType(es.getType())
                            .withUpdateRequest(new UpdateRequest().doc(Collections.singletonMap("userDetail_1",JSON.toJSONString(userDetail))))
                            .build();
                    updateQueries.add(updateQuery);
                });
        System.out.println("=======================updateQueries"+JSON.toJSONString(updateQueries));
        elasticsearchOperations.bulkUpdate(updateQueries);
    }




}
