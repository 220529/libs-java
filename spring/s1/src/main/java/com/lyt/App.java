package com.lyt;

import com.lyt.entity.Apple;
import com.lyt.entity.Child;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        Apple apple1 = new Apple("红富士", "红色", "欧洲");
        Apple apple2 = new Apple("青苹果", "绿色", "中亚");
        Apple apple3 = new Apple("金帅", "黄色", "中国");
        Child lily = new Child("莉莉", apple3);
        Child andy = new Child("安迪", apple2);
        Child luna = new Child("露娜", apple1);
        lily.eat();
        andy.eat();
        luna.eat();
    }
}
