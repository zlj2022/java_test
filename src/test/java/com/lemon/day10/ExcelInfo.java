package com.lemon.day10;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * @author :阿静
 * description：
 * data 2021/8/2918:20
 * Copyright:java自动化学习
 */
public class ExcelInfo {
    //使用注解，讲excel和实体类连接起来
    @Excel(name = "id")
    private int id;
    @Excel(name="name")
    private String name;
    @Excel(name="addres")
    private String addres;
    @Excel(name = "phone")
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
