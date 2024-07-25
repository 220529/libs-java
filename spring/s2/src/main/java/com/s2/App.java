package com.s2;

import com.s2.entity.Apple;
import com.s2.libs.ApplicationContext;
import com.s2.libs.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext();
            Apple apple = (Apple) context.getBean("sweetApple");
            System.out.println(apple);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
