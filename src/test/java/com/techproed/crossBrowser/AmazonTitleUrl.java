package com.techproed.crossBrowser;

import com.techproed.utilities.TestBaseCross;
import org.testng.annotations.Test;

public class AmazonTitleUrl extends TestBaseCross {

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
