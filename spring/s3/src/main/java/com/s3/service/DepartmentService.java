package com.s3.service;

import com.s3.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    @Autowired
    private Dao dao;

    public DepartmentService() {
        System.out.println("DepartmentService.constructor");
    }

    public void say() {
        System.out.println("DepartmentService.dao: " + dao);
    }
}
