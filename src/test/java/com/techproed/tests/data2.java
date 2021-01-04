package com.techproed.tests;

import com.techproed.pages.CkHotelsHomePage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class data2 {

    @Test (dataProvider = "girisBilgi")
    public void abc(String isim,String sifre){
        Driver.getDriver().get(ConfigReader.getProperty("ck_hotels_url"));

        CkHotelsHomePage ckHotelsHomePage=new CkHotelsHomePage();
        ckHotelsHomePage.ilkLogIn.click();
        ckHotelsHomePage.userNameTextBox.sendKeys(isim);
        ckHotelsHomePage.passwordTextBox.sendKeys(sifre);
        ckHotelsHomePage.loginButonu.click();
    }

    @DataProvider(name="girisBilgi")
    public Object[][] kullanicilar(){

        String kullanici[][]={{"ali","123"},{"veli","345"},{"hasan","456"}};



        return kullanici;
    }

}
