package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session, String enCode) {
        Admin admin = adminService.queryByname(username);
        String code = (String) session.getAttribute("Code");
        System.out.println(code);
        if (code.equals(enCode)) {
            if (admin == null) {
                return "账号错误";
            } else {
                if (admin.getPassword().equals(password)) {
                    session.setAttribute("admin", admin);
                    return "ok";
                } else {
                    return "密码错误";
                }
            }
        } else {
            return "验证码错误";
        }
    }
}
