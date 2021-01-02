package com.techproed.cross;

import com.techproed.pages.CkHotelsHomePage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseCross;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLogin extends TestBaseCross {

    @Test
    public void pozitifSmokeTest(){


        driver.get("http://qa-environment.crystalkeyhotels.com");
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("UserName")).sendKeys("manager");
        driver.findElement(By.id("Password")).sendKeys("Manager2!");
        driver.findElement(By.id("btnSubmit")).click();

    }

}
