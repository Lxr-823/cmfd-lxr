package com.baizhi;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;

@SpringBootTest(classes = CmfdLxrApplication.class)
@RunWith(SpringRunner.class)
public class wrokbook {

    @Test
    public void test1(){
        //创建一个表
        HSSFWorkbook sheets = new HSSFWorkbook();
        HSSFFont font = sheets.createFont();
        //加粗
        font.setBold(true);
        //红色
        font.setColor(Font.COLOR_RED);
        //字体
        font.setFontName("微软雅黑");
        //大小
        font.setFontHeightInPoints((short) 20);

        //创建一个工作薄
        HSSFSheet sheet = sheets.createSheet("工作一");
        //创建行
        HSSFRow row = sheet.createRow(0);
        //创建 单元格
        HSSFCell cell = row.createCell(0);
        HSSFCell cell1 = row.createCell(1);
        HSSFCell cell2 = row.createCell(2);
        HSSFCell cell3 = row.createCell(3);
        HSSFCell cell4 = row.createCell(4);
        //单元格赋值
        cell.setCellValue("ID");
        cell1.setCellValue("标题");
        cell2.setCellValue("图片");
        cell3.setCellValue("时间");
        cell4.setCellValue("状态");
        //指定excle输出的位置以及文件名
        try {
            sheets.write(new File("C:/Users/长安/Desktop/text.xls"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test2(){
        //1.创建excle文件
        HSSFWorkbook sheets = new HSSFWorkbook();
        HSSFDataFormat dataFormat = sheets.createDataFormat();
        short format = dataFormat.getFormat("yyyy-MM-dd");
        HSSFCellStyle cellStyle = sheets.createCellStyle();
        cellStyle.setDataFormat(format);

        HSSFFont font = sheets.createFont();
        font.setFontHeightInPoints((short) 20);
        font.setFontName("微软雅黑");
        font.setBold(true);
        font.setColor(Font.COLOR_NORMAL);

        HSSFCellStyle cellStyle1 = sheets.createCellStyle();
        cellStyle1.setFont(font);
        cellStyle1.setAlignment(HorizontalAlignment.CENTER);

        //创建 工作薄
        HSSFSheet sheet = sheets.createSheet("工作表2");
        sheet.setColumnWidth(4,20*256);
        //创建行
        HSSFRow row = sheet.createRow(0);
        //自定义标题行


    }
}
