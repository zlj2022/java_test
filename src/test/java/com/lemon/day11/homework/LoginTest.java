package com.lemon.day11.homework;

import org.testng.annotations.*;

/**
 * @author :阿静
 * description：
 * data 2021/9/517:20
 * Copyright:java自动化学习
 */
public class LoginTest {
    /**
     * 1、请实现以下功能测试代码：
     * （1）有LoginTest与RegisterTest两个测试类
     * （2）在所有测试类运行之前打印输出：全局初始化操作
     * （3）在测试类LoginTest运行之前打印输出：登录测试类执行开始
     * （4）在测试方法loginSuccess()运行之前打印输出：登录测试方法执行开始
     * （5）在测试方法loginSuccess()运行之后打印输出：登录测试方法执行结束
     * （6）在测试类LoginTest运行之后打印输出：登录测试类执行结束
     * 2、基于上一题，请在RegisterTest测试类中实现读取附件中Excel文件的数据，编写测试方法实现数据驱动。*/
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("2全局初始化");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("3登录测试类执行开始");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("4登录测试方法执行开始");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("5登录测试方法执行结束");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("6登录测试类执行结束");
    }
    @Test
    public void loginSuccess(){
        System.out.println("登录成功");
    }
}
