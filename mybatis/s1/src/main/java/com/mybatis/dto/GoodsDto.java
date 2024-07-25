package com.mybatis.dto;

import com.mybatis.entity.Category;
import com.mybatis.entity.Goods;

public class GoodsDto {
    private Goods goods = new Goods();
    private Category category = new Category();
    private String test;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
