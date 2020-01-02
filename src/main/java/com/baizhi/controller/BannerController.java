package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("Banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    //分页
    @ResponseBody
    @RequestMapping("all")
    public Map<String, Object> queryAll(Integer rows, Integer page) {
        Map<String, Object> map = bannerService.queryAll(rows, page);
        return map;
    }

    //增，删，改
    @RequestMapping("/edit")
    @ResponseBody
    public Map<String, String> edit(Banner banner, String oper, String[] id) {
        Map<String, String> map = new HashMap<>();
        if ("add".equals(oper)) {
            String s = UUID.randomUUID().toString();
            banner.setId(s);
           // Map<String, String> map = new HashMap<>();
            map.put("id", s);
            bannerService.addBanner(banner);
        } else if ("edit".equals(oper)) {
            if ("".equals(banner.getImg())){
                banner.setImg(null);
                bannerService.updateBanner(banner);
            }else {
                bannerService.updateBanner(banner);
                map.put("id",banner.getId());
            }



        } else if ("del".equals(oper)) {
            bannerService.deleteBanner(id);
        }
        return map;

    }

    @ResponseBody
    @RequestMapping("/upload")
    public String upload(MultipartFile img, HttpSession session, String bNid) {
        System.out.println(bNid);
        Banner banner = new Banner();
        String realPath = session.getServletContext().getRealPath("/img");
        File file1 = new File(realPath);
        if (!file1.exists()) {
            file1.mkdirs();
        }
        String filename = img.getOriginalFilename();
        String s=null;
             s = new Date().getTime() + "_" + filename;
            banner.setImg(s);
        try {
            img.transferTo(new File(realPath, s));
        } catch (IOException e) {
            e.printStackTrace();
        }
        banner.setId(bNid);
        System.out.println(banner);
        bannerService.updateBanner(banner);
        return null;
    }
}
