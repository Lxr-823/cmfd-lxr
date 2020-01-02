package com.baizhi.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/poi")
public class PoiController {
@Autowired
    private AdminService adminService;

@RequestMapping("/po")
    public void poi(HttpServletResponse response){
    //1.创建excle文件
    HSSFWorkbook sheets = new HSSFWorkbook();
    //设置字体
    HSSFFont font = sheets.createFont();
    font.setColor(Font.COLOR_RED);
    font.setBold(true);
    font.setFontName("微软雅黑");
    font.setFontHeightInPoints((short)10);

    HSSFCellStyle cellStyle = sheets.createCellStyle();
    cellStyle.setFont(font);
    cellStyle.setAlignment(HorizontalAlignment.CENTER);

    //2.创建 工作薄
    HSSFSheet sheet = sheets.createSheet("管理员信息");
    //3.创建行
    HSSFRow row = sheet.createRow(0);
    //自定义标题行
    String[] titles={"编号","账号","密码"};
    for (int i =0;i<titles.length;i++){
        String title =titles[i];
        HSSFCell cell = row.createCell(i);
        cell.setCellValue(title);
        cell.setCellStyle(cellStyle);
    }
    List<Admin> admins = adminService.queryAll();
    for (int i=0;i<admins.size();i++){
        HSSFRow row1 = sheet.createRow(i + 1);
        row1.createCell(0).setCellValue(admins.get(i).getId());
        row1.createCell(1).setCellValue(admins.get(i).getUsername());
        row1.createCell(2).setCellValue(admins.get(i).getPassword());
    }
    try {
        response.setHeader("content-disposition","attachment;filename=admin.xls");
        ServletOutputStream outputStream = response.getOutputStream();
        sheets.write(outputStream);
        outputStream.close();
      //  sheets.write(new File("C:\\Users\\长安\\Desktop/admin.xls"));
        sheets.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
@RequestMapping("/Easy")
    public void easyPoi(HttpServletResponse response){
    List<Admin> admins = adminService.queryAll();
    Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("管理员信息","管理员"),
            Admin .class, admins);
    response.setHeader("content-disposition","attachment;filename=admineasy.xls");
    try {
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

}
}
