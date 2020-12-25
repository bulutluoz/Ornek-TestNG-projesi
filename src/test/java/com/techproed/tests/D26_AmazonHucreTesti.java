package com.techproed.tests;

import com.aventstack.extentreports.ExtentReports;
import com.techproed.pages.AmazonPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.ReusableMethods;
import com.techproed.utilities.TestBaseRapor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class D26_AmazonHucreTesti extends TestBaseRapor {

    @Test
    public void hucreTest(){
        //Bu class’in altinda bir test method olusturun : hucretesti() ve
        // webtable’da 3. satir 7.sutundaki yazinin “Home Services” yazisi icerdigini test edin

        extentTest= extentReports.createTest("hucre testi","3.satir 7.sutundaki yazinin dogrulugunu test ettik");
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        extentTest.info("amazon sayfasina git");
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.enAltaGit();
        extentTest.info("en alta git");


        String hucreYazisi= amazonPage.hucreYazisiGetir(3,7);
        extentTest.info("istedim hucre yazisini al");
        Assert.assertTrue(hucreYazisi.contains(ConfigReader.getProperty("aranan_hucre")));
        extentTest.pass("hucredeki yazi dogru, test PASS");
    }

    @Test
    public void AmazonYazisi(){
        //tabloda 9 Hucrede “Amazon” yazisi bulundugunu test edin
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.enAltaGit();

        int kelimeSayici=0;

        for (int i=1 ; i<=amazonPage.satirlarListesi.size(); i+=2){
            for (int j=1 ; j<=amazonPage.birinciSatirElementleri.size(); j+=2){

                if (amazonPage.hucreYazisiGetir(i,j).contains(ConfigReader.getProperty("aranan_kelime"))){
                    kelimeSayici++;
                }
            }

        }

        System.out.println(kelimeSayici);
        Driver.closeDriver();
    }

}
