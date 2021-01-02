package com.techproed.cross;

import com.techproed.pages.CkHotelsHomePage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseCross;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLogin extends TestBaseCross {

    @Test
    public void yanlisUsername() {
        driver.get("http://qa-environment.crystalkeyhotels.com");
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("UserName")).sendKeys("manager1");
        driver.findElement(By.id("Password")).sendKeys("Manager2!");
        driver.findElement(By.id("btnSubmit")).click();
    }

    @Test
    public void yanlisPassword() throws InterruptedException {
        driver.get("http://qa-environment.crystalkeyhotels.com");
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("UserName")).sendKeys("manager");
        driver.findElement(By.id("Password")).sendKeys("Manager2");
        driver.findElement(By.id("btnSubmit")).click();
    }

    @Test
    public void yanlisKullaniciVeSifre()
    {
        driver.get("http://qa-environment.crystalkeyhotels.com");
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Manager2");
        driver.findElement(By.id("btnSubmit")).click();
    }
}



