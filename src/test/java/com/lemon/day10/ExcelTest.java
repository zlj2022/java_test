package com.lemon.day10;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author :阿静
 * description：
 * data 2021/8/2917:56
 * Copyright:java自动化学习
 * 本节讲excel的读写，和yaml文件的读取
 */
public class ExcelTest {
/**
 * POI，Apache软件基金会的开放源码函式库，POI提供API给Java程序对Microsoft Office格式档案读和
 写的功能
 Easypoi，国人开发，基于Apache poi二次定制开发，简化Excel操作
 先在pom.xml文件中导入easypoi-annotation，>easypoi-base文件*/
public static void main(String[] args) throws IOException {
    //1、先生成file文件对象（本地创建一个excel文件，存到resource下面）
    File file = new File("src\\test\\resources\\extest.xlsx");
    //实例化一个读取excel的对象
    ImportParams importParams = new ImportParams();
    //设置度那张sheet，从第几行开始，读几行
    importParams.setStartSheetIndex(0);//从第一张表开始读
    //读几张表
    //importParams.setSheetNum(1);//如果就读一张表，这个就不要用写了
    //从第几行开始读,读几行
    importParams.setStartRows(1);
    importParams.setReadRows(2);
    //用ExcelImportUtil的importExcel方法拿到数据，存到list数组中，list有三个参数：file对象，实体对象，读取对象
    //ExcelImportUtil是个类，导入后直接可以用，importExcel（）是个静态方法，可以直接调用
    List<ExcelInfo> allDatas = ExcelImportUtil.importExcel(file,ExcelInfo.class,importParams);
    for(ExcelInfo people:allDatas){
        System.out.println(people.getId()+" ");
        System.out.println(people.getName()+" ");
        System.out.println(people.getAddres()+" ");
        System.out.println(people.getPhone()+" ");
    }

    //写入excel
    //1、实例化写入对象
    ExportParams exportParams = new ExportParams();
    //写入到哪个表格
    exportParams.setSheetName("login");
    ExcelInfo people2 = new ExcelInfo();
    people2.setId(1);
    people2.setName("张阿静");
    people2.setAddres("广州");
    people2.setPhone("18678787878");
    //把这个people对象加到数组里，再由数组写入到表格中
    List<ExcelInfo> listData = new ArrayList<ExcelInfo>();
    listData.add(people2);
    //2、写入excel中exportExcel()先传写入对象，实体类，写入的数据
    Workbook wb = ExcelExportUtil.exportExcel(exportParams,ExcelInfo.class,listData);
    //写入用write，但要传OutputStream参数，而后者是个抽象类，所以用多态的方法，实例化父类接收子类方法
    OutputStream outputStream = new FileOutputStream("src\\test\\resources\\output.xls");//里面要传一个file
    wb.write(outputStream);//里面要传一个OutputStream对象,write要抛出异常

}




}
