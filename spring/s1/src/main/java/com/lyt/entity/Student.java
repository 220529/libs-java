package com.lyt.entity;

public class Student {
    private Subject subject;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Student() {
        System.out.println("Student...");
    }
}
