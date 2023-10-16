package Tests;

import Retry.RetryAnalyzer;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest {

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void goToLoginPage() {


        navPage.clickOnLangBtn();
        navPage.clickOnEngLangLink();
        navPage.clickOnLoginBtn();
        wait
                .withMessage("User Should Be on Login page")
                .until(ExpectedConditions.urlContains("/login"));


    }



}
