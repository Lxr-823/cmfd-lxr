package com.baizhi.serviceImpl;

import com.baizhi.service.kindeditorService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Service
public class kindeditorServiceImpl implements kindeditorService {
    @Override
    public Map<String,Object> uploadImg(MultipartFile img, HttpSession session, HttpServletRequest request) {
     /*   HashMap<String, Object> map = new HashMap<>();
        String realPath = session.getServletContext().getRealPath("/upload");
        File file = new File(realPath);
        if (!file.exists()){
            file.mkdirs();
        }
        String filename = img.getOriginalFilename();
        String name = new Date().getTime()+"_"+ filename;
        try {
             img.transferTo(new File(realPath,name));
             map.put("error",0);
            String scheme = request.getScheme();
            InetAddress localHost = InetAddress.getLocalHost();
            String s = localHost.toString().split("/")[1];
            int serverPort = request.getServerPort();
            String contextPath = request.getContextPath();
            String url=scheme+"://"+s+":"+serverPort+contextPath+"/upload/"+name;
            map.put("url",url);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
       /* return  map;*/
        return null;
    }
}
