package com.abc.ssm.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        Object zhao=ctx.getBean("zhao");
        System.out.println(zhao);
        Object wang=ctx.getBean("wang");
        System.out.println(wang);
    }
}
