package com.lyt.entity;

public class Cycle {
    private Float x;
    private Float y;
    private Float amount;

    public Cycle() {
        System.out.println("Cycle...");
    }

    public void init(){
        System.out.println("init...");
        amount = x + y;
    }

    public void init2(){
        System.out.println("init...");
        amount = x * y;
    }

    public void destroy(){
        System.out.println("destroy...");
    }

    public void say(){
        System.out.println("amount: " + amount);
    }

    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}
