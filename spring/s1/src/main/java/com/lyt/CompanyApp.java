package com.lyt;

import com.lyt.entity.Company;
import com.lyt.entity.Computer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CompanyApp {
    static String [] configs = {"classpath:application-company.xml"};
    public static void main(String[] args) {
        //创建Spring IoC容器,并根据配置文件在容器中实例化对象
        ApplicationContext context = new ClassPathXmlApplicationContext(configs);
        Company c1 = context.getBean("c1" , Company.class);

        System.out.println(c1.toString());

        String address = c1.getInfo().getProperty("address");
        System.out.println(address);

        String [] beanNames = context.getBeanDefinitionNames();
        for (String beanName:beanNames){
            System.out.println(beanName);
            System.out.println("类型:" + context.getBean(beanName).getClass().getName());
            System.out.println("内容:" + context.getBean(beanName));
        }

        Computer computer = context.getBean("com.lyt.entity.Computer", Computer.class);
        System.out.println(computer.getBrand());
        Computer computer1 = context.getBean("com.lyt.entity.Computer#1", Computer.class);
        System.out.println(computer1.getBrand());
    }
}
