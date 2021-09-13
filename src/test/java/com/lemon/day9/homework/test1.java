package com.lemon.day9.homework;

import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.List;
import java.util.Properties;

/**
 * @author :阿静
 * description：
 * data 2021/8/2916:47
 * Copyright:java自动化学习
 */
public class test1 {

    public static void main(String[] args) throws IOException {
        /**String json = {"name": "张三", "age": 18, "score":100};
         * 解析成Student对象。*/
        String json = "{\"name\": \"张三\",\"age\": 18,\"score\": 100}";//写好引号，之恶极复制过来
        //先创建一个实体类student
        Student s1 = JSONObject.parseObject(json,Student.class);
        String name = s1.getName();
        System.out.println(name);

        /**String json = [{"name": "张三", "age": 18, "score":100},{"name": "李四", "age": 16, "score":100}]
         * 解析成list对象*/
        String json2 = " [{\"name\": \"张三\", \"age\": 18, \"score\":100},{\"name\": \"李四\", \"age\": 16, \"score\":100}] ";
        List<Student> s2 = JSONObject.parseArray(json2,Student.class);
        //s2是一个集合，集合的元素，是一个student对象，所以循环取值时，要制定类型为对象
        for(Student ele:s2){
           /* System.out.println(ele);//ele是两个对象
            com.lemon.day9.homework.Student@4f2410ac
            com.lemon.day9.homework.Student@722c41f4*/
            //要去到对象的值，必须用对象的get方法
            System.out.println(ele.getName());
            System.out.println(ele.getAge());//张三/18/李四/16
        }

        /**{ "name": "中国", "provinces": [{ "name": "黑龙江", "capital": "哈尔滨" }, { "name": "广东", "capital": "广
         州" }, { "name": "湖南", "capital": "长沙" }] }
         解析成Java对象
         {
         "name": "中国",
         "provinces": [{
             "name": "黑龙江",
             "capital": "哈尔滨"
             },
             {
             "name": "广东",
             "capital": "广州 "
             },
             {
             "name ": "湖南 ",
             "capital ": "长沙 "
             }]
             }*/

        String json3 = "{ \"name\": \"中国\", \"provinces\": [{ \"name\": \"黑龙江\", \"capital\": \"哈尔滨\" }, { \"name\": \"广东\", \"capital\": \"广州\" }, { \"name\": \"湖南\", \"capital\": \"长沙\" }] }\n";
        //这个是国籍对象里面，嵌套省份对象，要建两个对象
        //先实例化国际对象，，拿到国籍，再去拿省份，城市
        //实例化一个国际对象就行了，省份对象要用数组
        Nation nation = JSONObject.parseObject(json3,Nation.class);
        System.out.println(nation.getName());
        List<Povincy> provicies = nation.getProvinces();
        for(Povincy pc:provicies){
            System.out.println(pc.getName());
            System.out.println(pc.getCapital());
        }


        /**4、解析properties文件
         env表示环境，有测试环境（test）、预发布环境（pre-release）、生产环境（production）
         version表示版本号要求：读取properties文件，通过env的值执行不同输出语句，如：env为test，则打印测试环境执行，版本
         号为1.1.0
         */

        Properties pro = new Properties();
        File file = new File("src\\test\\resources\\home.properties");
        InputStream inputStream = new FileInputStream(file);
        pro.load(inputStream);//加载配置文件
        //拿到配置文件env的值
        String env = pro.getProperty("env");
        if ("test".equals(env)) {
            System.out.println("这是测试环境");
            System.out.println("版本号为：" + pro.getProperty("version"));
        } else if ("pre-test".equals(env)) {
            System.out.println("这是预发布环境");
            System.out.println("版本号为：" + pro.getProperty("version"));
        } else if ("prod".equals(env)) {
            System.out.println("这是生产环境");
            System.out.println("版本号为：" + pro.getProperty("version"));
        }
    }


}
