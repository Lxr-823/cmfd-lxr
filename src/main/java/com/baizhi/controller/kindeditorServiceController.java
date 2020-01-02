package com.baizhi.controller;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/kindeditor")
public class kindeditorServiceController {
    /*@Autowired
    private kindeditorService kindeditorService;
*/
    @ResponseBody
    @RequestMapping("/kin")
   /* public Map<String,Object> kindeditor(MultipartFile img, HttpSession session, HttpServletRequest request){
        Map<String, Object> map = kindeditorService.uploadImg(img, session, request);
        return  map;
    }*/
    public Map<String, Object> uploadImg(MultipartFile img, HttpSession session, HttpServletRequest request) {
        HashMap<String, Object> map = new HashMap<>();
        String realPath = session.getServletContext().getRealPath("/upload");
        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String filename = img.getOriginalFilename();
        String name = new Date().getTime() + "_" + filename;
        try {
            img.transferTo(new File(realPath, name));
            map.put("error", 0);
            String scheme = request.getScheme();
            InetAddress localHost = InetAddress.getLocalHost();
            String s = localHost.toString().split("/")[1];
            int serverPort = request.getServerPort();
            String contextPath = request.getContextPath();
            String url = scheme + "://" + s + ":" + serverPort + contextPath + "/upload/" + name;
            map.put("url", url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
    @ResponseBody
    @RequestMapping("/img")
    public Map<String,Object> queryImg(HttpSession session,HttpServletRequest request){
        HashMap<String, Object> map1 = new HashMap<>();
        String realPath = session.getServletContext().getRealPath("/upload");
        File file = new File(realPath);
        String[] list = file.list();
        List<Object> list1 = new ArrayList<>();
        for (String s : list) {
            File file1 = new File(realPath,s);
            long length = file1.length();
            HashMap<String, Object> map = new HashMap<>();
            map.put("is_dir",false);
            map.put("has_file",false);
            map.put("filesize",length);
            map.put("dir_path","");
            map.put("is_photo",true);
            String extension = FilenameUtils.getExtension(s);
            map.put("filetype",extension);
            map.put("filename",s);
            String s1 = s.split("_")[0];
            Long aLong = Long.valueOf(s1);
            Date date = new Date(aLong);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String format = simpleDateFormat.format(date);
            map.put("datetime",format);
            list1.add(map);
        }
        map1.put("file_list",list1);
        map1.put("moveup_dir_path","");
        map1.put("current_dir_path","");
        String scheme = request.getScheme();
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            String s = localHost.toString().split("/")[1];
            int serverPort = request.getServerPort();
            String contextPath = request.getContextPath();
            String current_url=scheme+"://"+s+":"+serverPort+contextPath+"/upload/";
            map1.put("current_url",current_url);
            map1.put("total_count",list.length);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return  map1;
    }
}
