package com.baizhi.serviceImpl;

import com.baizhi.Vo.UserVo;
import com.baizhi.dao.T_userDao;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private T_userDao tUserDao;


    //鸡图
    @Override
    public List<UserVo> selectAll() {
        List<UserVo> userVos = tUserDao.selectAll();
        return userVos;
    }

    //月份销量图
    @Override
    public List<UserVo> selectMonth() {
        List<UserVo> userVos = tUserDao.selectMonth();

        return userVos;
    }

    @Override
    public List<Integer> selectday(Integer day) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            Integer selectday = tUserDao.selectday(i);
            list.add(selectday);
        }
        return list;
    }

    @Override
    public void deleteById(String id) {
        tUserDao.delete(id);
    }

}
