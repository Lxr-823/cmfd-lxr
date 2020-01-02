package com.baizhi.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

public interface kindeditorService {

    public Map<String,Object> uploadImg(MultipartFile img, HttpSession session, HttpServletRequest request);
}
