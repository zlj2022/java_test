package com.lemon.day11;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * @author :阿静
 * description：
 * data 2021/9/323:07
 * Copyright:java自动化学习
 */
public class ExcelBean {
    @Excel(name = "phone")
    private String phone;
    @Excel(name="password")
    private String password;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
