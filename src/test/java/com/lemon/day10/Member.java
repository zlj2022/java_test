package com.lemon.day10;

import java.util.List;

/**
 * @author :阿静
 * description：
 * data 2021/8/2920:46
 * Copyright:java自动化学习
 */
 /*  yaml文件的内容
    name:lemon
    age:18
    isSingle:true
    phone:~
    data:2021-08-25
    address:"广东 广州"*/
public class Member {

    private String name;
    private int age;
    private String isSingle;
    private String phone;
    private String data;
    //private String address;
    /*如果address是个对象，声明时，就要声明其类型，这样的话就要新建一个address实体类
    address:
     privince:湖南
     city:长沙*/
    private Address address;
    private List<Address> provinces;//provinces是给数组+对象的复合类型，所以用list接受，
                                    // 而provices的key和address是一样的，所以泛型用address
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

    public String getIsSingle() {
        return isSingle;
    }

    public void setIsSingle(String isSingle) {
        this.isSingle = isSingle;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

   /* public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }*/

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Address> getProvinces() {
        return provinces;
    }

    public void setProvinces(List<Address> provinces) {
        this.provinces = provinces;
    }
}

