package com.payegis.test;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.WriteTable;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.payegis.excelListener.excelEntity.AddressInfo;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ReadFilesFromFolder {

    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
            String path = "D:/outPut/test.xlsx";
            File file = new File(path);
            File tempfile = new File("D:/outPut/地域标签测试数据.8ue.xlsx");
            //ExcelWriter writer = EasyExcel.write(file, AddressInfo.class).registerWriteHandler(new LongestMatchColumnWidthStyleStrategy()).build();
            ExcelWriter writer = EasyExcel.write(file, AddressInfo.class).withTemplate(tempfile).registerWriteHandler(new LongestMatchColumnWidthStyleStrategy()).build();

        //同一个sheet只能创建一次
        WriteSheet writeNormalSheet = EasyExcel.writerSheet("ES异常数据").build();
        List<AddressInfo> list = new ArrayList<>();
        AddressInfo addressInfo = new AddressInfo();
        addressInfo.setApplyId("11111111111");
        addressInfo.setRequestSerialNo("222222222222");
        list.add(addressInfo);

        writer.write(list,writeNormalSheet);
        tempfile.delete();
            writer.finish();

    }



}
