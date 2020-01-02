package com.baizhi.serviceImpl;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl  implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Admin queryByname(String username) {
        Admin admin = adminDao.queryByname(username);
        return admin;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Admin> queryAll() {
        List<Admin> admins = adminDao.queryAdmin();
        return admins;
    }
}
