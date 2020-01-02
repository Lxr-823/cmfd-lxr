package com.baizhi;

import io.goeasy.GoEasy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CmfdLxrApplication.class)
public class GoEasyTest {

    @Test
    public void goEasy(){
        GoEasy goEasy= new GoEasy("http://rest-hangzhou.goeasy.io","BC-8378c280d60049809b4a7cc347b9a247");
        goEasy.publish("Myeasy", "Hello, GoEasy!");
    }
}
