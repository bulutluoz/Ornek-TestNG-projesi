package com.techproed.cross;

import com.techproed.utilities.TestBaseCross;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class AmazonTitleCross extends TestBaseCross {

    @Test
    public void title(){
        driver.get("https://www.amazon.com");

        System.out.println(driver.getTitle());
    }

    @Test
    public void url(){
        driver.get("https://www.amazon.com");

        System.out.println(driver.getCurrentUrl());
    }
}
