package com.techproed.tests;

import com.techproed.utilities.ExcelUtil;
import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class D35_ReadExcel {


    @Test
    public void readExcel() throws IOException {

        String path="src/test/java/resources/baskentler.xlsx";
        FileInputStream fileInputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        Sheet sheet=workbook.getSheetAt(0);
        Row row=sheet.getRow(21);
        Cell cell=row.getCell(2);

        System.out.println(cell);

        String baskentIsmi=cell.toString();


        System.out.println(baskentIsmi);

        Assert.assertEquals(baskentIsmi,"Ankara");

        //satir sayisini bulalim

        int satirSayisi=workbook.getSheetAt(0).getLastRowNum();
        System.out.println("satir sayisi : " + satirSayisi);


        //Tum baskentleri yazdiralim

        for (int i=0;i<satirSayisi;i++){
            System.out.println(workbook.getSheetAt(0).getRow(i).getCell(2));
        }

        // sayfa 2 icin son satir numarasi ve kullanilan satir sayisini bulalim
        System.out.println("son satir no "+workbook.getSheetAt(1).getLastRowNum());
        System.out.println("fiziksel satir sayisi " + workbook.getSheetAt(1).getPhysicalNumberOfRows());

        // 4.satirdaki 2.hucredeki bilgiyi yazdirin
        System.out.println(workbook.getSheetAt(0).getRow(3).getCell(1));

        // baskenti Ankara olan ulkenin tum bilgilerini yazdirin
        for (int i=0 ; i<satirSayisi ;i++){

            if (workbook.getSheetAt(0).getRow(i).getCell(2).toString().toLowerCase().equals("ankara")){
                System.out.println("Sira no : " + workbook.getSheetAt(0).getRow(i).getCell(0).toString()
                + " Ulke ismi : " + workbook.getSheetAt(0).getRow(i).getCell(1).toString()
                + " Baskent : " + workbook.getSheetAt(0).getRow(i).getCell(2).toString()
                + " Nufus : " + workbook.getSheetAt(0).getRow(i).getCell(3).toString()
                + " Yil : " + workbook.getSheetAt(0).getRow(i).getCell(4).toString()
                + " Nufus orani : " + workbook.getSheetAt(0).getRow(i).getCell(5).toString());
            }
        }


    }

    @Test
    public void test2(){
        ExcelUtil excelUtil=new ExcelUtil("src/test/java/resources/baskentler.xlsx","Sayfa1");
        //3.indexe sahip satirdaki 1.indexe sahip hucredeki yaziyi yazdirin
        System.out.println(excelUtil.getCellData(3,1));

        // 22 satirdaki baskent isminin Ankara oldugunu test edin
        Assert.assertEquals(excelUtil.getCellData(21,2),"Ankara");
        // basliklari yazdirin
        System.out.println("basliklar " + excelUtil.getColumnsNames());

        //sutun sayisini bulalim

        System.out.println("sutun sayisi " + excelUtil.columnCount());

        // exceldeki tum bilgileri bir map'e aktaralim

        List<Map<String,String>> tumDataList=excelUtil.getDataList();

        System.out.println(tumDataList);

        // istedigim bir bilgiyi iceren ulkenin tum bilgilerini yazdirin

        // liste= [{},{},{},{Toplam nufusa orani=0.0672, Sira=21.0, Başkent=Ankara, Yıl=2014.0, Ulke=Türkiye, Nufus=5.150.072}]
        //

        for (Map w:tumDataList
             ) {
            if (w.containsValue("2012.0")){
                System.out.println(w);
            }
        }



    }
}
