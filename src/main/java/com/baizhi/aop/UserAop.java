package com.baizhi.aop;


import com.baizhi.Vo.UserVo;
import com.baizhi.service.UserService;
import io.goeasy.GoEasy;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Aspect
public class UserAop {

    @Autowired
    private UserService userService;

    @Around(value = ("execution(* com.baizhi.serviceImpl.UserServiceImpl.deleteById(..))"))
    public Object userAop(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("aop 切入");
        List<Map<Integer,String>> list = new ArrayList<>();
        Object proceed=null;
        HashMap<Integer, String> map = new HashMap<>();
        try {
           proceed = proceedingJoinPoint.proceed();
            List<UserVo> list1 = userService.selectAll();
            //发送数据
            GoEasy goEasy = new GoEasy("http://rest-hangzhou.goeasy.io", "BC-8378c280d60049809b4a7cc347b9a247");
            goEasy.publish("easy",list.toString());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return proceed;
    }

}
