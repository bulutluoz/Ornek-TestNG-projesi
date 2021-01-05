package com.techproed.tests;

import com.techproed.pages.CkHotelsHomePage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseRapor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class D25_HtmlRapor1 extends TestBaseRapor {

    @Test
    public void pozitifSmokeTest(){

        //1- Test class’ini extends ile TestBaseRapor Class’ina child yapalim
        //2- extentTest=extentReports.createTest(“Test ismi”, “Tanim”);  rapor olusturalim
        //3- Gerekli/istedigimiz satirlara extentTest.info(“Aciklama”) ekleyelim
        //4- Assert olan satirda aciklamayi extentTest.pass ile yapabiliriz
        extentTest=extentReports.createTest("ck hotel pozitif login", "dogru kullanici adi ve sifresi girdigimde sayfaya login olmaliyim");

        CkHotelsHomePage ckHotelsHomePage=new CkHotelsHomePage();


        Driver.getDriver().get(ConfigReader.getProperty("ck_hotels_url"));
        extentTest.info("ck hotels ana sayfaya git");
        ckHotelsHomePage.ilkLogIn.click();
        ckHotelsHomePage.userNameTextBox.sendKeys(ConfigReader.getProperty("ck_hotels_user"));
        extentTest.info("dogru kullanici adi girildi");
        ckHotelsHomePage.passwordTextBox.sendKeys(ConfigReader.getProperty("ck_hotel_password"));
        extentTest.info("dogru sifre girildi");
        ckHotelsHomePage.loginButonu.click();

        Assert.assertTrue(Driver.getDriver().getTitle().contains(ConfigReader.getProperty("ck_title_basarili")));
        extentTest.pass("sayfaya basarili sekilde girildigi test edildi");
        Driver.closeDriver();
    }

    @Test
    public void yanlisUsername() {
        //2- extentTest=extentReports.createTest(“Test ismi”, “Tanim”);  rapor olusturalim
        //3- Gerekli/istedigimiz satirlara extentTest.info(“Aciklama”) ekleyelim
        //4- Assert olan satirda aciklamayi extentTest.pass ile yapabiliriz
        extentTest=extentReports.createTest("negative login testi", "yanlis username dogru sifre ilr giris yapilamaz");
        Driver.getDriver().get(ConfigReader.getProperty("ck_hotels_url"));
        extentTest.info("ck hotels anasayfaya gidildi");
        CkHotelsHomePage ckHotelsHomePage = new CkHotelsHomePage();
        ckHotelsHomePage.ilkLogIn.click();
        ckHotelsHomePage.userNameTextBox.sendKeys(ConfigReader.getProperty("ck_invalid_user"));
        extentTest.info("kullanici adi olarak invalid user name kullanildi");
        ckHotelsHomePage.passwordTextBox.sendKeys(ConfigReader.getProperty("ck_hotel_password"));
        extentTest.info("dogru sifre girildi");
        ckHotelsHomePage.loginButonu.click();

        Assert.assertTrue(Driver.getDriver().getTitle().contains(ConfigReader.getProperty("ck_title_basarili")));
        extentTest.pass("sayfaya giris yapilamadi");
        Driver.closeDriver();
    }

}
