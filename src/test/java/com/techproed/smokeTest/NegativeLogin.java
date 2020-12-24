package com.techproed.smokeTest;

import com.techproed.pages.CkHotelsHomePage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLogin {

    @Test
    public void yanlisUsername() {
        Driver.getDriver().get(ConfigReader.getProperty("ck_hotels_url"));
        CkHotelsHomePage ckHotelsHomePage = new CkHotelsHomePage();
        ckHotelsHomePage.ilkLogIn.click();
        ckHotelsHomePage.userNameTextBox.sendKeys(ConfigReader.getProperty("ck_invalid_user"));
        ckHotelsHomePage.passwordTextBox.sendKeys(ConfigReader.getProperty("ck_hotel_password"));
        ckHotelsHomePage.loginButonu.click();

        Assert.assertTrue(ckHotelsHomePage.girilemediYazisi.isDisplayed());
        Driver.closeDriver();
    }

    @Test
    public void yanlisPassword() throws InterruptedException {
        Thread.sleep(3000);
        Driver.getDriver().get(ConfigReader.getProperty("ck_hotels_url"));
        CkHotelsHomePage ckHotelsHomePage = new CkHotelsHomePage();
        ckHotelsHomePage.ilkLogIn.click();
        ckHotelsHomePage.userNameTextBox.sendKeys(ConfigReader.getProperty("ck_hotels_user"));
        ckHotelsHomePage.passwordTextBox.sendKeys(ConfigReader.getProperty("ck_wrong_password"));
        ckHotelsHomePage.loginButonu.click();

        Assert.assertTrue(ckHotelsHomePage.girilemediYazisi.isDisplayed());
        Driver.closeDriver();
    }

    @Test
    public void yanlisKullaniciVeSifre()
    {
        Driver.getDriver().get(ConfigReader.getProperty("ck_hotels_url"));
        CkHotelsHomePage ckHotelsHomePage = new CkHotelsHomePage();
        ckHotelsHomePage.ilkLogIn.click();
        ckHotelsHomePage.userNameTextBox.sendKeys(ConfigReader.getProperty("ck_invalid_user"));
        ckHotelsHomePage.passwordTextBox.sendKeys(ConfigReader.getProperty("ck_wrong_password"));
        ckHotelsHomePage.loginButonu.click();

        Assert.assertTrue(ckHotelsHomePage.girilemediYazisi.isDisplayed());
        Driver.closeDriver();
    }
}



