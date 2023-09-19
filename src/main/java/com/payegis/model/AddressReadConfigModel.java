package com.payegis.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */
@Data
@Component
@ConfigurationProperties(prefix = "address.read")
public class AddressReadConfigModel {

    /**
     * 单次读取行数
     */
    private int batchCount;

    /**
     * 未调用ES生成的文件
     */
    private String tempFileLocation;
    /**
     * 调用ES生成的文件
     */
    private String tempESFileLocation;

    /**
     * 是否需要读取es
     */
    private Boolean readEs;


}
