package com.techproed.tests;

import com.techproed.pages.AmazonPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class D32_DataProviderTest {


    @DataProvider
    public static Object[] kelimeListesi() {
        Object[] aranacaklar =new Object[4];
        aranacaklar[0]="Nutella";
        aranacaklar[1]="pencil";
        aranacaklar[2]="tomateos";
        aranacaklar[3]="samsung";

        return aranacaklar;
    }

    @Test (dataProvider = "kelimeListesi")
    public void amazonArama(String arananKelimeler){
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(arananKelimeler+ Keys.ENTER);
        System.out.println(amazonPage.sonucYazisiElementi.getText());
        Driver.closeDriver();
    }



}
