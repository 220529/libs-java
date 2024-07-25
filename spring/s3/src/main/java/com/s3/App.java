package com.s3;

import com.s3.service.UserService;
import com.s3.service.DepartmentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        System.out.println("======IoC容器已初始化=======");

        UserService u1 = context.getBean("userService", UserService.class);
        System.out.println(u1.getDao());
//        System.out.println(u1.getName());
//        System.out.println(u1.getPassword());

        UserService u2 = context.getBean("userService", UserService.class);
        System.out.println(u2.getDao());

//        DepartmentService d1 = context.getBean("departmentService", DepartmentService.class);
//        d1.say();

//        String[] ids = context.getBeanDefinitionNames();
//        for(String id : ids){
//            System.out.println("id: " + id + ":" + context.getBean(id));
//        }
    }
}
