package com.lemon.day10.homework;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * @author :阿静
 * description：
 * data 2021/8/2922:36
 * Copyright:java自动化学习
 */
public class RegisterInfo {
    @Excel(name = "序号(caseId)")
    private int caseId;
    @Excel(name = "接口模块(interface)")
    private String interfaces;
    @Excel(name = "用例标题(title)")
    private String title;
    @Excel(name = "请求头(requestHeader)")
    private String requestHeader;
    @Excel(name = "请求方式(method)")
    private String method;
    @Excel(name = "接口地址(url)")
    private String url;
    @Excel(name = "参数输入(inputParams)")
    private String inputPatams;
    @Excel(name = "期望返回结果(expected)")
    private String expected;

    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public String getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(String interfaces) {
        this.interfaces = interfaces;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRequestHeader() {
        return requestHeader;
    }

    public void setRequestHeader(String requestHeader) {
        this.requestHeader = requestHeader;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getInputPatams() {
        return inputPatams;
    }

    public void setInputPatams(String inputPatams) {
        this.inputPatams = inputPatams;
    }

    public String getExpected() {
        return expected;
    }

    public void setExpected(String expected) {
        this.expected = expected;
    }
}
