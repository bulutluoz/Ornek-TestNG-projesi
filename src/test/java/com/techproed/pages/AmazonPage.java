package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class AmazonPage {

    public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> satirlarListesi;

    @FindBy(xpath = "(//tr[1])//td")
    public List<WebElement> birinciSatirElementleri;




    //AmazonPage sayfasinda istedigim satir ve sutun sayisi ile cagirdigimda
    // bana hucredeki yaziyi getirecek bir method olusturun

    public String hucreYazisiGetir(int satir,int sutun){

        String hucreXpath="//tr["+satir+"]//td["+sutun+"]";

        String hucredekiYazi=Driver.getDriver().findElement(By.xpath(hucreXpath)).getText();
        return hucredekiYazi;
    }


    public void enAltaGit(){
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END).perform();
    }
}
