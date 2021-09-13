package com.lemon.day10.homework;

import java.util.List;

/**
 * @author :阿静
 * description：
 * data 2021/9/320:59
 * Copyright:java自动化学习
{ "name": "中国",
  "provinces": [{ "name": "黑龙江", "capital": "哈尔滨" },
                { "name": "广东", "capital": "广州" },
                { "name": "湖南", "capital": "长沙" }]
 */

public class NationBean {

    private String name;
    private List<Province> provinces;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Province> getProvinces() {
        return provinces;
    }

    public void setProvinces(List<Province> provinces) {
        this.provinces = provinces;
    }
}
