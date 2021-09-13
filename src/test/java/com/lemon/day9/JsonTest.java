package com.lemon.day9;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author :阿静
 * description：
 * data 2021/8/2518:37
 * Copyright:java自动化学习
 */
public class JsonTest {
    /**
     * JSON语法规则：
     * 1. 数据在键值对中
     * 2. 数据由逗号分隔
     * 3. 大括号 {} 保存对象{“”：“”}
     * 4. 中括号 [] 保存数组[{},{}]
     * 还可以组合 {"":"","":[{},{}]}
     * JSON值类型：
     * 数字（整数或浮点数）,字符串（在双引号中）,逻辑值（true 或 false）
     * 数组（在中括号中）,对象（在大括号中）,null
         *{
         "name": "rose",
         "age": 10,
         "height": 180.5,
         "isSingle": false,
         "address": {
         "provinces": "湖南省",
         "city": "长沙"
         },
         "weight":null
         }
     * */

    /**fastjson技术
    Java对象与JSON之间的相互转换（对象变成json字符串）序列化与（json字符串变成对象）反序列化操作)
    https://github.com/alibaba/fastjson/wiki/Quick-Start-CN*/
    public static void main(String[] args) {
        //json字符串转 Java对象,要传入实体参照类
        String str1 = "{\"name\": \"张三\",\"age\": 18}";//直接Jason格式写好弄成一行复制过来，自动转义
        Student s = JSONObject.parseObject(str1,Student.class);
        //System.out.println(s.getName());
        //System.out.println(s.getAge());

        //json字符串 转map，不用传实体类
        Map<String,Object> map = JSONObject.parseObject(str1);
        /*System.out.println(map.get("name"));
        System.out.println(map.get("age"));*/

        //json字符串，转，前提是个数组的字符串，需要传入实体类
        String str2 = "[{\"name\": \"张三\",\"age\": 18}]";
        List<Student> list = JSONObject.parseArray(str2,Student.class);
        //列表的读取要用for循环System.out.println(list.name);
        for (Student student:list) {
            //System.out.println(ele);
            System.out.println(student.getName());
            System.out.println(student.getAge());
        }

        //Java对象转 json字符串
        //实例化Java对象
        Student student = new Student();
        student.setName("李四");
        student.setAge(20);
        String str3 = JSONObject.toJSONString(student);
        System.out.println(str3);//{"age":20,"name":"李四"}

        //map转 json字符串
        //首先，要实例化一个map，而map本身是个接口，不能实例化，可以用多态的方法，接受其子类hashmap
        Map<String,Object> map1 = new HashMap<String, Object>();
        map1.put("hobby","睡觉");
        map1.put("age",25);
        String str4 = JSONObject.toJSONString(map1);
        System.out.println(str4);
    }




}
