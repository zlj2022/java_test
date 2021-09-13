package com.lemon.day9;

import java.io.*;
import java.util.Properties;

/**
 * @author :阿静
 * description：
 * data 2021/8/2916:33
 * Copyright:java自动化学习
 * Properties文件解析
 *
 */
public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        //解耦，读取配置文件,先实例化一个properties对象
        Properties properties = new Properties();
        File file = new File("src\\test\\resources\\test.properties");
        InputStream inputStream = new FileInputStream(file);
        //InputStream是个抽象类，不能直接实例化，用多态承接子类对象，FileInputStream，本身要传一个file参数
        //用properties对象，自身的load（）函数，加载配置文件
        properties.load(inputStream);//需要传入输入流InputStream
        //获取对应的数据
        String name = properties.getProperty("name");
        String addres = properties.getProperty("addres");
        String port = properties.getProperty("port");
        System.out.println(name);
        System.out.println(addres);
        System.out.println(port);
    }

}
