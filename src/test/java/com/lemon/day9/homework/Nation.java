package com.lemon.day9.homework;

import java.util.List;

/**
 * @author :阿静
 * description：
 * data 2021/8/2917:12
 * Copyright:java自动化学习
 */
public class Nation {
    private String name;
    private List<Povincy> provinces;//用列表去承接省份对象

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Povincy> getProvinces() {
        return provinces;
    }

    public void setProvinces(List<Povincy> provinces) {
        this.provinces = provinces;
    }
}
