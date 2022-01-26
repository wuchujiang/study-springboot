package com.study.springboot;

import com.study.springboot.mapper.CategoryMapper;
import org.apache.ibatis.annotations.Mapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration

@Controller
public class DefaultTest {


    @Before
    public void init() {
        System.out.println("开始测试----------");
    }

    @Test
    public void testa(){
    }

    @After
    public void after() {

        System.out.println("结束测试");
    }
}
