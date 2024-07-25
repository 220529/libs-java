package com.s3.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Primary
@Scope("prototype")
public class OracleDao implements Dao {
    public OracleDao() {
        System.out.println("OracleDao.constructor");
    }
}
