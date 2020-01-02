package com.baizhi;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = CmfdLxrApplication.class)
@RunWith(SpringRunner.class)
public class CmfdLxrApplicationTests {
@Autowired
    private AdminDao adminDao;
    @Test
    public void contextLoads() {
        Admin lxr = adminDao.queryByname("lxr");
        System.out.println(lxr);
    }

}
