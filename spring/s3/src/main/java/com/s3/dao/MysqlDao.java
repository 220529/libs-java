package com.s3.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MysqlDao implements Dao {
    public MysqlDao() {
        System.out.println("MysqlDao.constructor");
    }
}
