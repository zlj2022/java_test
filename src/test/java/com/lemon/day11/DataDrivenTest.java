package com.lemon.day11;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

/**
 * @author :阿静
 * description：
 * data 2021/9/322:49
 * Copyright:java自动化学习
 */
public class DataDrivenTest {

    //数据驱动，就是有一个数据提供者dataprovider，使用二维数组提供一些数据，给测试方法使用，简化传参
   /**
   //存放测试用例的数据
   //数据的存储方式可以有多种：1、存到excel，2、存到yaml 3、存到数据库   4、存到json

   }*/
    @Test(dataProvider = "getDatas")//这个是取用json格式的数据源
    public void loginFailure(String phone,String password) {
        System.out.println("手机号：" + phone + "  密码：" + password);
    }

    @Test(dataProvider = "getDatas02")
    public void loginFailure(ExcelBean excelBean){
        System.out.println("手机号："+excelBean.getPhone()+"  密码："+excelBean.getPassword());

    }
    //1\存到jaon
    @DataProvider
    public Object[][] getDatas(){

        Object[][] datas = {
                //这些数据，先传到getData里面，然后再传给loginFailure的参数
                {"18614985234","123456"},
                {"","123456"},
                {"18614985234",""}
        };
        return datas;
    }

    //2、存到excel
    @DataProvider
    public Object[] getDatas02(){
        //读取excel
        ImportParams importParams = new ImportParams();
        File file = new File("src\\test\\java\\com\\lemon\\day11\\casedata.xlsx");
        List<ExcelBean> listData = ExcelImportUtil.importExcel(file,ExcelBean.class,importParams);
        //转成数组
        Object[] datas = listData.toArray();
        /*for (Object ob :datas){
            ExcelBean eb = (ExcelBean)ob;
            System.out.println(eb.getPhone());
            System.out.println(((ExcelBean) ob).getPassword());
        }*/
        return datas;
    }
}