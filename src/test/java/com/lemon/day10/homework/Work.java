package com.lemon.day10.homework;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author :阿静
 * description：
 * data 2021/8/2922:17
 * Copyright:java自动化学习
 */
public class Work {
    //private static Object NationBean;

    /**
     * 1.读取下面的Excel文件，通过Java对象集合接收，并转成数组，最后循环遍历数组输出。
     * 2.将以下json字符串转成YAML格式文件：
     * { "name": "中国", "provinces": [{ "name": "黑龙江", "capital": "哈尔滨" }, { "name": "广东", "capital": "广
     * 州" }, { "name": "湖南", "capital": "长沙" }] */
    public static void main(String[] args) throws IOException {
        ReadExcel("src\\test\\java\\com\\lemon\\day10\\homework\\api_testcases_futureloan_v1.xls");
        //ReadYaml();
    }
    public static void ReadExcel(String file){
        //先创建excel实体类，并讲excel表头对接好
        //1、先生成file文件对象
        File f = new File(file);
        //实例化一个读取excel的对象
        ImportParams importParams = new ImportParams();
        importParams.setStartSheetIndex(0);//从第一张表开始读
        //从第几行开始读,读几行
        importParams.setStartRows(0);
        //importParams.setReadRows(2);，allDatas现在是个集合
        List<RegisterInfo> allDatas = ExcelImportUtil.importExcel(f,RegisterInfo.class,importParams);
        System.out.println(allDatas.getClass());//class java.util.ArrayList
        //题目要求转成数组
        Object[] arr = allDatas.toArray();//用object[ ]是因为，toArray（）默认是object
        //System.out.println(arr.getClass());class [Ljava.lang.Object;
        for(Object obj:arr){
            //System.out.println(obj.getClass());class com.lemon.day10.homework.RegisterInfo
            //由于obj也是数组，所以要强转成对象,或者在toArray（）的地方直接清强转RegisterInfo[] arr = (RegisterInfo) allDatas.toArray();
            RegisterInfo re = (RegisterInfo) obj;
            System.out.print(re.getCaseId()+" ");
            System.out.print(re.getTitle()+" ");
            System.out.print(re.getRequestHeader()+" ");
            System.out.print(re.getMethod()+" ");
            System.out.print(re.getUrl()+" ");
            System.out.print(re.getInputPatams()+" ");
            System.out.print(re.getExpected()+" ");
            System.out.println();

        }
    }
    /**将以下json字符串转成YAML格式文件*/
    public static void ReadYaml() throws IOException {
        String str="{ \"name\": \"中国\", \"provinces\": [{ \"name\": \"黑龙江\", \"capital\": \"哈尔滨\" }, { \"name\": \"广东\", \"capital\": \"广州\" }, { \"name\": \"湖南\", \"capital\": \"长沙\" }]}";
        //字符串先转成Java对象，在转yaml
        NationBean allDatas = JSONObject.parseObject(str, NationBean.class);
        /*System.out.println(allDatas.getName());
        System.out.println(allDatas.getProvinces());
        这里输出的是对象地址[com.lemon.day10.homework.Province@726f3b58, com.lemon.day10.homework.Province@442d9b6e, com.lemon.day10.homework.Province@ee7d9f1]
        */
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        //把Java对象转成yaml对应的字符串
        //String str2 = objectMapper.writeValueAsString(allDatas);
        //System.out.println(str2);
        //转成yaml文件
        objectMapper.writeValue(new File("output.yaml"),allDatas);


    }
}
