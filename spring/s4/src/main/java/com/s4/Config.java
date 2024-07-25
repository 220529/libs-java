package com.s4;

import com.s4.controller.UserController;
import com.s4.dao.MysqlDao;
import com.s4.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {
    @Bean
    MysqlDao mysqlDao() {
        return new MysqlDao();
    }
    @Bean
    @Scope("prototype")
    UserService userService() {
        UserService userService = new UserService();
        userService.setMysqlDao(mysqlDao());
        return userService;
    }
    @Bean
    @Scope("prototype")
    UserController userController() {
        UserController userController = new UserController();
        userController.setUserService(userService());
        return userController;
    }
}
