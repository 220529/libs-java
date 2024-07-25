package com.lyt;

import com.lyt.entity.Apple;
import com.lyt.entity.Child;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp {
    static String [] configs = {"classpath:application-property.xml", "classpath:application-constructor.xml"};
    public static void main(String[] args) {
        //创建Spring IoC容器,并根据配置文件在容器中实例化对象
        ApplicationContext context = new ClassPathXmlApplicationContext(configs);
        Apple sweetApple = context.getBean("sweetApple" , Apple.class);
        System.out.println(sweetApple.getTitle());

        Child luna = context.getBean("luna" , Child.class);
        luna.eat();

        Apple softApple = context.getBean("softApple" , Apple.class);
        System.out.println(softApple.getTitle());

        Child lily = context.getBean("lily" , Child.class);
        lily.eat();
    }
}
