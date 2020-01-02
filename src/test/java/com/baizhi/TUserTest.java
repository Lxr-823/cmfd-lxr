package com.baizhi;

import com.baizhi.Vo.UserVo;
import com.baizhi.dao.T_userDao;
import com.baizhi.entity.TUser;
import com.baizhi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CmfdLxrApplication.class)
public class TUserTest {
    @Autowired
    private T_userDao tUserDao;
    @Autowired
    private UserService userService;

    @Test
    public void test1(){
        List<TUser> tUsers = tUserDao.queryAll();
        for (TUser tUser : tUsers) {
            System.out.println(tUser);
        }
           }


        //鸡图
          @Test
    public void test2(){
               List<UserVo> userVos = tUserDao.selectAll();
               for (UserVo userVo : userVos) {
                   System.out.println(userVo);
               }
           }

           //月份 柱图
    @Test
    public void  test3(){
        List<UserVo> userVos = tUserDao.selectMonth();
        for (UserVo userVo : userVos) {
            System.out.println(userVo);
        }
    }
    @Test
    public void test4(){
        userService.deleteById("1");
    }
}
