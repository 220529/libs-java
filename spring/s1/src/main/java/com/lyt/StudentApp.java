package com.lyt;

import com.lyt.entity.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentApp {
    static String [] configs = {"classpath:application-scope.xml"};
    public static void main(String[] args) {
        //创建Spring IoC容器,并根据配置文件在容器中实例化对象
        ApplicationContext context = new ClassPathXmlApplicationContext(configs);
        System.out.println("======IoC容器已初始化=======");

        Subject subject1 = context.getBean("subject" , Subject.class);
        System.out.println(subject1);
        Subject subject2 = context.getBean("subject" , Subject.class);
        System.out.println(subject2);

        Student student1 = context.getBean("student" , Student.class);
        System.out.println(student1);
        Student student2 = context.getBean("student" , Student.class);
        System.out.println(student2);

        Cycle cycle = context.getBean("cycle" , Cycle.class);
        System.out.println(cycle);
        cycle.say();
    }
}
