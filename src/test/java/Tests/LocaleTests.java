package Tests;

import Retry.RetryAnalyzer;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest{

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void verifyESLanguageChange(){
        navPage.clickOnLangBtn();
        navPage.clickOnEspLangLink();
        navPage.waitUntiltextIsInEsp();


    }









}
