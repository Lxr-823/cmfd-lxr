package com.baizhi;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CmfdLxrApplication.class)
public class AdminTest {
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private AdminService adminService;
    @Test
    public void test1(){
        List<Admin> admins = adminDao.queryAdmin();
        for (Admin admin : admins) {
            System.out.println(admin);
        }
    }
    @Test
    public void test2(){
        try {
            //1.创建excle文件 并且读入对应的excle
            HSSFWorkbook sheets = new HSSFWorkbook(new FileInputStream("C:\\Users\\长安\\Desktop/admineasy.xls"));
            //2. 获得sheet 工作簿
            HSSFSheet sheet = sheets.getSheet("管理员");
            //3.获取最后一行的下标
            int lastRowNum = sheet.getLastRowNum();
            List<Admin> list = new ArrayList<>();
            for (int i = 2; i <= lastRowNum; i++) {
                String id=sheet.getRow(i).getCell(0).getStringCellValue();
                String username= sheet.getRow(i).getCell(1).getStringCellValue();
                String password =sheet.getRow(i).getCell(2).getStringCellValue();
                Admin admin = new Admin(id, username, password);
                list.add(admin);
            }
            for (Object o : list) {
                System.out.println(o);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void test3(){
        Integer count = adminDao.selecyCount();
        System.out.println(count);
    }
}
