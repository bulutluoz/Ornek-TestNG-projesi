package com.techproed.tests;

import com.techproed.pages.AmazonPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.ReusableMethods;
import com.techproed.utilities.TestBaseRapor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class D26_AmazonSatirSutunSayisi extends TestBaseRapor {

    @Test
    public void satirSayisi(){
        extentTest=extentReports.createTest("satir sayisi","amazon sayfasindaki web table satir sayisini bulma");

        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        extentTest.info("amazon sayfasina git");
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.enAltaGit();
        extentTest.info("en alta in");
        System.out.println(amazonPage.satirlarListesi.size());
        extentTest.info("tablodaki satir sayisini al");
        Assert.assertTrue(amazonPage.satirlarListesi.size()==10);
        extentTest.pass("satir sayisinin 10 oldugunu test et");

        Driver.closeDriver();
    }

    @Test
    public void sutunSayisi(){
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.enAltaGit();

        System.out.println(amazonPage.birinciSatirElementleri.size());
        Assert.assertTrue(amazonPage.birinciSatirElementleri.size()==14);
        Driver.closeDriver();
    }
}
