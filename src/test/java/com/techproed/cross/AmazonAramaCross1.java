package com.techproed.cross;

import com.techproed.utilities.DriverCross;
import com.techproed.utilities.TestBaseCross;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AmazonAramaCross1 extends TestBaseCross {

    @Test
    public void arama1()  {
        WebDriverWait wait = new WebDriverWait(driver,5);
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
        System.out.println(driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText());

    }
    @Test
    public void arama2(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("pencil"+ Keys.ENTER);
        System.out.println(driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText());
    }
    @Test
    public void arama3(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("tomatoes"+ Keys.ENTER);
        System.out.println(driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText());
    }

}
