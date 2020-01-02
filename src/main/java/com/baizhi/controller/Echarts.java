package com.baizhi.controller;

import com.baizhi.Vo.UserVo;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Echarts")
public class Echarts {
@Autowired
private UserService userService;
    @RequestMapping("/echa")
    @ResponseBody
public List<UserVo> echarts(){
        List<UserVo> userVos = userService.selectAll();
        return userVos;
    }

    @RequestMapping("/month")
    @ResponseBody
    public List<String> selectMonth(){
        List<UserVo> userVos = userService.selectMonth();
        Map<Integer, String> map = new HashMap<>();
        for (UserVo userVo : userVos) {
            map.put(userVo.getValue(),userVo.getName());
        }
        List<String> list = new ArrayList<>();
        for (int i = 1; i <13; i++) {
            if (map.get(i)!=null){
                list.add(map.get(i));
            }else {
                list.add("0");
            }
        }
        return  list;
    }




    @ResponseBody
    @RequestMapping("/day")
    public List<Integer> selectday(Integer day){
        List<Integer> selectday = userService.selectday(day);
        return  selectday;
    }
}
