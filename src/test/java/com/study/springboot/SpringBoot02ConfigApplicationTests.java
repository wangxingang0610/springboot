package com.study.springboot;

import com.study.springboot.domain.Person;
import com.study.springboot.domain.Person1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * SpringBoot单元测试;
 *
 * 可以在测试期间很方便的类似编码一样进行自动注入等容器的功能
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot02ConfigApplicationTests {

    @Autowired
    Person person;


//    @Autowired
//    Person1 person1;

    @Test
    public void contextLoads() {
        System.out.println("\n");

        //方式1：@ConfigurationProperties
        System.out.println(person);

        //方式2：@Value
//        System.out.println(person1);
//        System.out.println("\n");
    }




    @Autowired
    ApplicationContext ioc;
    @Test
    public void testHelloService(){

        boolean helloService = ioc.containsBean("helloService");

        System.out.println(helloService);
    }






}

