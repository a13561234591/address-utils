package com.payegis.controller;


import com.alibaba.excel.EasyExcel;
import com.payegis.common.CommonResult;
import com.payegis.excelListener.AddressListener;
import com.payegis.excelListener.UpdateElasticListener;
import com.payegis.excelListener.excelEntity.AddressInfo;
import com.payegis.model.AddressReadConfigModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/**
 * EasyExcel导入导出
 *
 * @author william@StarImmortal
 */
@Slf4j
@RestController
@RequestMapping("/excel")
public class ExcelController {


    @Autowired
    AddressReadConfigModel addressReadConfigModel;

    @Value("${address.read.path}")
    String fileReadPath;

    /**
     * 更新es时使用
     */
    @Value("${address.read.tempFileLocation}")
    String esFileReadPath;

    @Autowired
    ExecutorService executorService;

    /**
     * 上传一个excel，经过解析--重写，生成新的excel返回
     *
     * @param
     * @param
     */
    @GetMapping("/import")
    public CommonResult<List<String>> importExcel() throws IOException, InterruptedException {
        LocalDateTime start = LocalDateTime.now();
        log.info("文件解析开始");
        List<String> errorMessageList = new ArrayList<>();
        File folder = new File(fileReadPath);
        if (!folder.isDirectory()) {
            return CommonResult.failed("文件读取路径错误，非文件夹:" + fileReadPath);
        }
        // 获取文件夹中的所有文件
        File[] files = folder.listFiles();
        if (ObjectUtils.isEmpty(files)) {
            return CommonResult.failed("文件读取路径下没有文件");
        }
        CountDownLatch countDownLatch = new CountDownLatch(files.length);
        //循环读取文件
        for (File file : files) {
            if (!file.isFile()) {
                continue;
            }
            // 获取文件名
            String originalFilename = file.getName();
            log.info("当前读取文件:{}", originalFilename);
            originalFilename = originalFilename.toLowerCase();
            String s1 = originalFilename.substring(originalFilename.indexOf('.') + 1)
                    .toLowerCase();
            // 文件格式作校验
            if (!"xlsx".equals(s1) && !"xls".equals(s1)) {
                errorMessageList.add("非excel文件格式...:" + originalFilename);
                countDownLatch.countDown();
                continue;
            }

            // 判断文件是否为空
            if (ObjectUtils.isEmpty(file)) {
                errorMessageList.add(originalFilename + "文件为空...:");
                countDownLatch.countDown();
                continue;
            }

            originalFilename = originalFilename.replace("xlsx", "").replace("xls", "");
            AddressListener addressListener = new AddressListener(originalFilename);

            FileInputStream inputStream = new FileInputStream(file);
            //每个文件开一个线程
            executorService.submit(() -> {
                try {
                    //读文件
                    EasyExcel.read(inputStream, AddressInfo.class, addressListener).sheet().doRead();
                    inputStream.close();
                } catch (Exception e) {
                    log.error("文件读取异常:",e);
                    errorMessageList.add("文件处理异常:" + s1);
                    try {
                        inputStream.close();
                    } catch (IOException ex) {
                        log.error("文件流关闭失败");
                    }
                } finally {
                    countDownLatch.countDown();
                }
            });
            log.info("文件:{}读取完成", originalFilename);
        }

        countDownLatch.await();
        LocalDateTime end = LocalDateTime.now();
        Duration duration = Duration.between(start, end);
        long seconds = duration.getSeconds();
        log.info("文件解析总用时:{}秒", seconds);
        // 返回响应
        return CommonResult.success(errorMessageList);

    }

    @GetMapping("/update")
    public CommonResult<List<String>> importExcelToUpdateEs() throws IOException, InterruptedException {
        LocalDateTime start = LocalDateTime.now();
        log.info("更新ES开始");
        List<String> errorMessageList = new ArrayList<>();
        File folder = new File(esFileReadPath);
        if (!folder.isDirectory()) {
            return CommonResult.failed("文件读取路径错误，非文件夹：" + esFileReadPath);
        }
        // 获取文件夹中的所有文件
        File[] files = folder.listFiles();
        if (ObjectUtils.isEmpty(files)) {
            return CommonResult.failed("文件读取路径下没有文件");
        }
        CountDownLatch countDownLatch = new CountDownLatch(files.length);
        //循环读取文件
        for (File file : files) {
            if (!file.isFile()) {
                continue;
            }
            // 获取文件名
            String originalFilename = file.getName();
            log.info("当前读取文件:{}", originalFilename);
            originalFilename = originalFilename.toLowerCase();
            // 文件格式作校验
            if (!originalFilename.endsWith("xlsx") && !originalFilename.endsWith("xls")) {
                errorMessageList.add("非excel文件格式...:" + originalFilename);
                countDownLatch.countDown();
                continue;
            }
            // 判断文件是否为空
            if (ObjectUtils.isEmpty(file)) {
                errorMessageList.add(originalFilename + "文件为空...:");
                countDownLatch.countDown();
                continue;
            }
            UpdateElasticListener listener = new UpdateElasticListener(originalFilename);
            FileInputStream inputStream = new FileInputStream(file);

            //每个文件开一个线程
            executorService.submit(() -> {
                try {
                    //读文件
                    EasyExcel.read(inputStream, AddressInfo.class, listener).sheet().doRead();
                    inputStream.close();
                } catch (Exception e) {
                    log.error("文件读取异常:",e);
                    try {
                        inputStream.close();
                    } catch (IOException ex) {
                        log.error("文件流关闭失败");
                    }
                } finally {
                    countDownLatch.countDown();
                }
            });
            log.info("文件:{}读取完成", originalFilename);
        }

        countDownLatch.await();
        LocalDateTime end = LocalDateTime.now();
        Duration duration = Duration.between(start, end);
        long seconds = duration.getSeconds();
        log.info("ES更新总用时:{}秒", seconds);
        // 返回响应
        return CommonResult.success(errorMessageList);

    }


}
