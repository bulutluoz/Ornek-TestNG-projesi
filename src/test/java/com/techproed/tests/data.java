package com.techproed.tests;

import com.techproed.pages.AmazonPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class data {

    @Test(dataProvider = "aranacaklar")
    public void test(String aranan){
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(aranan+ Keys.ENTER);

    }

    @DataProvider(name="aranacaklar")
    public Object[] getUrunler(){
        String  aranacaklar[] = {"Ali","Veli","Hasan","Huseyin","Yasar"};

        return aranacaklar;
    }

}
