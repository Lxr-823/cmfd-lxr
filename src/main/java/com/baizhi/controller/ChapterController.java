package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import it.sauronsoftware.jave.Encoder;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/Chapter")
public class ChapterController {


    @Autowired
    private ChapterService chapterService;
    @ResponseBody
    @RequestMapping("/cha")
    public Map<String,Object> chapterAll(String id,Integer rows, Integer page){
        Map<String, Object> map = chapterService.queryAll(id, rows, page);
        return  map;
    }

    @ResponseBody
    @RequestMapping("/edit")
    public Map<String, String> edit(Chapter chapter, String oper, String[] id,String idd) {
        Map<String, String> map = new HashMap<>();
        if ("del".equals(oper)){
            chapterService.deleteChapter(id);
        }else if ("add".equals(oper)){
            String s= UUID.randomUUID().toString();
            chapter.setId(s);
            chapter.setAlbum_id(idd);
            map.put("id",s);
            chapterService.addChapter(chapter);
        }else if ("edit".equals(oper) ){
            if ("".equals(chapter.getSrc())){
                chapter.setSrc(null);
                map.put("id",null);
                chapterService.updateChapter(chapter);
            }else{
                chapterService.updateChapter(chapter);
                map.put("id",chapter.getId());
            }

        }
        return  map;
    }

    //上传
   @ResponseBody
    @RequestMapping("/upload")
    public String upload(MultipartFile src, HttpSession session,String id){
       Chapter chapter = new Chapter();
       String realPath = session.getServletContext().getRealPath("/audio");
       File file = new File(realPath);
       if (!file.exists()){
           file.mkdirs();
       }
       String filename = src.getOriginalFilename();
       chapter.setTitle(filename);
       String s = new Date().getTime() + "_" + filename;
       //获取音频大小  字节
       long size = src.getSize();
      String sizes = size/1024/1024+"MB";
       chapter.setSize(sizes);

       //获取音频时长
       Encoder encoder = new Encoder();
       chapter.setSrc(s);
       if (new File(realPath,s)!=null){
           try {
               src.transferTo(new File(realPath,s));
               long duration = encoder.getInfo(new File(realPath, s)).getDuration();
               String lengh=  duration/1000/60+"分"+duration/1000%60+"秒";
               chapter.setDuration(lengh);
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
       chapter.setId(id);
       chapterService.updateChapter(chapter);
       return  null;
   }
//下载
    @ResponseBody
    @RequestMapping("/download")
    public String download(String id, HttpServletResponse response,HttpServletRequest request) {
       Chapter chapter = chapterService.selectById(id);
        String src = chapter.getSrc();
        response.setHeader("content-disposition","attachment;fileName="+src);
        //接收数据  文件标识 文件名
        String realPath = request.getSession().getServletContext().getRealPath("/audio");
        //获取文件类型通过文件获取文件后缀
        String extension = FilenameUtils.getExtension(src);
        String mimeType = request.getSession().getServletContext().getMimeType("."+extension);
        response.setContentType(mimeType);
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(realPath, src));
            ServletOutputStream outputStream = response.getOutputStream();
            byte[] bytes = new byte[2048];
            while (true) {
                int i = fileInputStream.read(bytes, 0, bytes.length);
                if (i == -1) break;
                outputStream.write(bytes, 0, i);
            }
            fileInputStream.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

       /* //获取路径
        String realPath = request.getSession().getServletContext().getRealPath("/audio");
        File file = new File(realPath, src);
        String s = src.split("_")[1];
        try {
            String encode = URLEncoder.encode(s, "UTF-8");
            response.setHeader("content-disposition","attachment;filename="+encode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        ServletOutputStream outputStream=null;
        try {
            outputStream = response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        return null;
    }
}
