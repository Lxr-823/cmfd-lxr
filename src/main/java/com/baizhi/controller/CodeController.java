package com.baizhi.controller;

import com.baizhi.util.ValidateImageCodeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RequestMapping("code")
@RestController
public class CodeController {

    @RequestMapping("getCode")
    public void getCode(HttpServletResponse response, HttpSession session) {
        //1.回执验证码中的字符
        String securityCode = ValidateImageCodeUtils.getSecurityCode();
        session.setAttribute("Code",securityCode);
        //2.通过生成的字符回执图片
        BufferedImage image = ValidateImageCodeUtils.createImage(securityCode);
        //2.通过图片的输出流，写到页面
        ServletOutputStream outputStream = null;
            try {
                outputStream = response.getOutputStream();
                ImageIO.write(image, "png", outputStream);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
}