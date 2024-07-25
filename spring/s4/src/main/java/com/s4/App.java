package com.s4;

import com.s4.controller.UserController;
import com.s4.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        System.out.println("======IoC容器已初始化=======");

//        String[] ids = context.getBeanDefinitionNames();
//        for(String id : ids){
//            System.out.println("id: " + id + ":" + context.getBean(id));
//        }

        UserService u1 = (UserService) context.getBean("userService");
        System.out.println("u1: " + u1.getMysqlDao());
        System.out.println("u1: " + u1.getOracleDao());

        UserController c1 = (UserController) context.getBean("userController");
        UserController c2 = (UserController) context.getBean("userController");
        System.out.println("c1: " + c1.getUserService());
        System.out.println("c2: " + c2.getUserService());
    }
}
