package com.techproed.tests;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class D35_WriteExcel {

    @Test
    public void writeExcel() throws IOException {

        String path="src/test/java/resources/baskentler.xlsx";
        FileInputStream fileInputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(fileInputStream);

        workbook.getSheetAt(0).getRow(0).createCell(6).setCellValue("neyi meshur");
        workbook.getSheetAt(0).getRow(1).createCell(6).setCellValue("ordek");


        FileOutputStream fileOutputStream=new FileOutputStream(path);
        workbook.write(fileOutputStream);

        // ordek kelimesinin o hucreye yazildigini test edelim

        Assert.assertEquals(workbook.getSheetAt(0).getRow(1).getCell(6).toString(),"ordek");

    }

}
