package com.example.proiecttimeea;

import java.util.Date;

public class Angajat {
    private String id;

    @Override
    public String toString() {
        return "Angajat{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", hireDate=" + hireDate +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Angajat(String id, String userId, String name, int age, Date hireDate) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.hireDate = hireDate;
    }

    private String userId;
    private String name;
    private int age;
    private Date hireDate;
}
