package com.s3.service;

import com.s3.dao.Dao;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class UserService {
    @Value("${name}")
    private String name;
    @Value("${user.password}")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Autowired
    private Dao dao;

    public UserService() {
        System.out.println("UserService.constructor");
    }

    @PostConstruct // ML中bean init-method完全相同
    public void init() {
        System.out.println("UserService.init");
    }

    public Dao getDao() {
        return dao;
    }
//    @Autowired
    public void setDao(Dao dao) {
        System.out.println("UserService.setDao: " + dao);
        this.dao = dao;
    }
}
