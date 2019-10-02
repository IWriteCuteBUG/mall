package com.cskaoyan.mall;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.beans.beancontext.BeanContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.cskaoyan.mall.mapper")
public class MallApplicationTests {

    @Autowired
    ApplicationContext applicationContext;
    @Test
    public void contextLoads() {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);

        }
    }

}
