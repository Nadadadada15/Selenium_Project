package Tests;

import Retry.RetryAnalyzer;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest{

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void verifyESLanguageChange() {
        navPage.clickOnLangBtn();
        navPage.clickOnEspLangLink();
        navPage.waitUntiltextIsInEsp();
    }


    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void verifyENLanguageChange()  {
        navPage.clickOnLangBtn();
        navPage.clickOnEngLangLink();
        navPage.waitUntiltextIsInEng();
    }


    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void verifyFRLanguageChange()  {
        navPage.clickOnLangBtn();
        navPage.clickOnFraLangLink();
        navPage.waitUntiltextIsInFra();
    }

    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void verifyCHLanguageChange()  {
        navPage.clickOnLangBtn();
        navPage.clickOnChiLangLink();
        navPage.waitUntiltextIsInChi();
    }

    @Test(priority = 5, retryAnalyzer = RetryAnalyzer.class)
    public void verifyUKRLanguageChange()  {
        navPage.clickOnLangBtn();
        navPage.clickOnUkrLangLink();
        navPage.waitUntiltextIsInUkr();
    }







}
