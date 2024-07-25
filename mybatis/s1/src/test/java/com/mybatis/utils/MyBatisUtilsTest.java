package com.mybatis.utils;

import junit.framework.TestCase;
import com.mybatis.dto.GoodsDto;
import com.mybatis.entity.Goods;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mybatis.utils.MyBatisUtils;

public class MyBatisUtilsTest extends TestCase {
    @Test
    public void testSqlSessionFactory() throws IOException {
        System.out.println("testSqlSessionFactory...");
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        System.out.println("加载成功");
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            Connection connection = sqlSession.getConnection();
            System.out.println("connection: " + connection);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    @Test
    public void testMyBatisUtils() {
        System.out.println("testMyBatisUtils...");
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSqlSession();
            Connection connection = sqlSession.getConnection();
            System.out.println("connection: " + connection);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }
    @Test
    public void testSelectAll() {
        System.out.println("testSelectAll...");
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSqlSession();
            List<Goods> goods = sqlSession.selectList("goods.selectAll");
            for(Goods g : goods){
                System.out.println("title: " + g.getTitle());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testSelectById() {
        System.out.println("testSelectById...");
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSqlSession();
            Goods goods = sqlSession.selectOne("goods.selectById", 2672);
            System.out.println("selectById: " + goods.getTitle());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testSelectByPriceRange() {
        System.out.println("testSelectById...");
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSqlSession();
            HashMap hashMap = new HashMap();
            hashMap.put("min", 200);
            hashMap.put("max", 250);
            hashMap.put("limit", 3);
            List<Goods> goods = sqlSession.selectList("goods.selectByPriceRange", hashMap);
            for(Goods g : goods){
                System.out.println("title: " + g.getTitle());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testSelectGoodsMap() {
        System.out.println("testSelectGoodsMap...");
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSqlSession();
            List<Map> goods = sqlSession.selectList("goods.selectGoodsMap");
            for(Map g : goods){
                System.out.println("g: " + g);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testSelectGoodsDto() {
        System.out.println("testSelectGoodsDto...");
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSqlSession();
            List<GoodsDto> goods = sqlSession.selectList("goods.selectGoodsDto");
            for(GoodsDto g : goods){
                System.out.println("dto: " + g);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testInsertGoods() {
        System.out.println("testInsertGoods...");
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSqlSession();
            Goods goods = new Goods();
            goods.setTitle("title");
            goods.setSubTitle("测试子标题");
            goods.setOriginalCost(200f);
            goods.setCurrentPrice(100f);
            goods.setDiscount(0.5f);
            goods.setIsFreeDelivery(1);
            goods.setCategoryId(43);
            sqlSession.insert("goods.insertGoods", goods);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testUpdateGoods() {
        System.out.println("testUpdateGoods...");
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSqlSession();
            Goods goods = sqlSession.selectOne("goods.selectById", 2676);

            goods.setTitle("73278");
            System.out.println("goods: " + goods);
            int num = sqlSession.update("goods.updateGoods", goods);
            sqlSession.commit();
            System.out.println("num: " + num);
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testDeleteGoods() {
        System.out.println("testDeleteGoods...");
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSqlSession();
            sqlSession.delete("goods.deleteGoods", 2675);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }
}