package com.s2.entity;

public class Apple {
    private String title;
    private String color;
    private String origin;

    public Apple() {
        System.out.println("Apple.no.params");
    }

    public Apple(String title, String color, String origin) {
        System.out.println("Apple.params: " + title + color + origin);
        this.title = title;
        this.color = color;
        this.origin = origin;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
