package com.lemon.day10;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;
/**yaml文件解析*/
public class YamlTest {
    public static void main(String[] args) throws IOException {
        //实例化objectMapper对象，mapper===》映射
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        //使用 objectMapper.readValue(）函数解析yaml文件，需要传入文件路径，实体类两个参数
        File file =new File("src\\test\\resources\\test2.yml");
        //读取出来的是一个member对象，用member接受
        Member member = objectMapper.readValue(file,Member.class);
        System.out.println(member.getName());
        System.out.println(member.getPhone());//输出为null
        //System.out.println(member.getAddress());
        //要用对象接收address
        Address address = member.getAddress();
        System.out.println(address.getProvince());
        System.out.println(address.getCity());
        //或者直接用以下这种方法也行
        System.out.println(member.getAddress().getCity());

        //获取数组+对象的复合结构的数据,provinces是个对象
        List<Address> provinces = member.getProvinces();
        for(Address pro:provinces){
            System.out.println(pro.getProvince());
            System.out.println(pro.getCity());
        }
    }
}
