package com.lemon.day11.homework;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

/**
 * @author :阿静
 * description：
 * data 2021/9/517:23
 * Copyright:java自动化学习
 */
public class RegisterTest {
  /**2、基于上一题，请在RegisterTest测试类中实现读取附件中Excel文件的数据，编写测试方法实现数据驱动。*/
  @Test(dataProvider = "datas")
  public void register(ExcelBean excelBean){
      System.out.print("序号："+excelBean.getId()+"标题："+excelBean.getTitle()+"输入数据："+excelBean.getInputParams()+"预期结果："+excelBean.getExpected());
  }

  @DataProvider
  public Object[] datas(){
      ImportParams importParams = new ImportParams();
      importParams.setStartSheetIndex(0);
      importParams.setStartRows(0);
      File file = new File("src\\test\\java\\com\\lemon\\day10\\homework\\api_testcases_futureloan_v1.xls");
      List<ExcelBean> allDatas = ExcelImportUtil.importExcel(file,ExcelBean.class,importParams);
      Object[] array = allDatas.toArray();
      return array;

  }



}
