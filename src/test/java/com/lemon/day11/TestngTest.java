package com.lemon.day11;

import org.testng.annotations.*;

/**
 * @author :阿静
 * description：
 * data 2021/9/321:54
 * Copyright:java自动化学习
 */
public class TestngTest {
    /**
     * TestNG（Testing Next Generation，技下一代测试术，是一个单元测试框架，它提供了一系列的丰富注解
     * （标签）来帮助我们很方便的编写和管理被测项目的测试类和测试方法，
     * 而且功能比junit更强大，支持依赖测试，忽略测试，异常测试，超时测试等多种测试场景
     * 点击哪个方法的执行，就执行哪个方法
     * 想全部执行，就点类
     * 根据方法名，按ASKII码排序，F在S前，所以loginFailuer比logjnSucess先执行
     *
     * */
    //testng常用注解
 /*   @BeforeSuite
    public void beferSuite(){
        System.out.println("打开电脑");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("关闭电脑");
    }
    @BeforeTest
    public void beferTest(){
        System.out.println("初始化");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("关闭初始化");
    }
    @BeforeClass
    public void befoerClass(){
        //befoerClass和afterClass，是在类执行前要执行的
        System.out.println("打开浏览器");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("关闭浏览器");
    }
    @BeforeMethod
    public void berforeMethond(){
        //BeforeMethod/AfterMethod这种，是在方法执行前/后，都执行，有多少方法执行多少次
        System.out.println("打开登录网址");
    }
    @AfterMethod
    public void afterMethod(){
        //BeforeMethod/AfterMethod这种，是在方法执行前/后，都执行，有多少方法执行多少次
        System.out.println("关闭登录网址");
    }*/
    //priority是配置用例执行的优先级，越小的越优先
    @Test(priority = 1)
    public void logjnSucess(){
        System.out.println("登录成功");
    }

    //timeOut是设置用例执行时间超过多少毫秒则为失败
    //org.testng.internal.thread.ThreadTimeoutException:
    // Method com.lemon.day11.TestngTest.loginFailuer01() didn't finish within the time-out 5000
    @Test(priority = 2,timeOut = 5000)
    public void loginFailuer01() throws InterruptedException {
        Thread.sleep(6000);
        System.out.println("手机号超过11位");
    }

    //enabled==false可以设置这条用例暂时不执行
    @Test(priority = 3,enabled = false)
    public void loginFailuer02(){
        System.out.println("非数字");
    }

    /**Testng参数化
     * 法一：
     *     使用testng.xml配置文件，利用parameter属性，
     *     <suite name="Suite" parallel="false">
             *  <test name="登录">
             *    <classes>
             *      <class name="com.lemon.phoenix.LoginTest"/>
             *    </classes>
             *  </test>
             *     <parameter name="mobilephone" value="18588220000"/>
             *      <parameter name="password" value="123456"/>
        * </suite
     * 然后再用例方法中加   @Parameters(value = {"mobilephone","password"})
     * */
    @Test
    @Parameters(value={"mobilephone","password"})
    public void register(String mobilephone,String password){
        System.out.println("手机号："+mobilephone+"  密码：+"+password);
    }

}
