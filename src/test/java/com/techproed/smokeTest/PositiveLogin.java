package com.techproed.smokeTest;

import com.techproed.pages.CkHotelsHomePage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLogin {
    // http://qa-environment.crystalkeyhotels.com adresine gidip login tusuna click yapalim
    // dogru kullanici adi ve sifre kullandigimizda sayfaya giris yapabildigimizi test edelim

    @Test
    public void pozitifSmokeTest(){
        CkHotelsHomePage ckHotelsHomePage=new CkHotelsHomePage();

        Driver.getDriver().get(ConfigReader.getProperty("ck_hotels_url"));
        ckHotelsHomePage.ilkLogIn.click();
        ckHotelsHomePage.userNameTextBox.sendKeys(ConfigReader.getProperty("ck_hotels_user"));
        ckHotelsHomePage.passwordTextBox.sendKeys(ConfigReader.getProperty("ck_hotel_password"));
        ckHotelsHomePage.loginButonu.click();
        Assert.assertTrue(Driver.getDriver().getTitle().contains(ConfigReader.getProperty("ck_title_basarili")));
        Driver.closeDriver();
    }

}
