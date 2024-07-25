package com.oa.service;

import com.oa.entity.Node;
import com.oa.mapper.RbacMapper;

import java.util.List;

public class RbacService {
    private RbacMapper rbacMapper = new RbacMapper();
    public List<Node> selectNodeByUserId(Long userId){
        return rbacMapper.selectNodeByUserId(userId);
    }
}
