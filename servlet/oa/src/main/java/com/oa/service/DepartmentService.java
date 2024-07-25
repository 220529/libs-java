package com.oa.service;

import com.oa.entity.Department;
import com.oa.mapper.DepartmentMapper;
import com.oa.utils.MybatisUtils;

public class DepartmentService {
    public Department selectById(Long departmentId){
        return (Department)MybatisUtils.executeQuery(sqlSession -> sqlSession.getMapper(DepartmentMapper.class).selectById(departmentId));
    }
}
