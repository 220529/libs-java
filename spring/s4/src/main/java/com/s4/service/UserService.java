package com.s4.service;

import com.s4.dao.MysqlDao;
import com.s4.dao.OracleDao;

public class UserService {
    public MysqlDao getMysqlDao() {
        return mysqlDao;
    }

    public void setMysqlDao(MysqlDao mysqlDao) {
        this.mysqlDao = mysqlDao;
    }

    public OracleDao getOracleDao() {
        return oracleDao;
    }

    public void setOracleDao(OracleDao oracleDao) {
        this.oracleDao = oracleDao;
    }

    private MysqlDao mysqlDao;
    private OracleDao oracleDao;
}
