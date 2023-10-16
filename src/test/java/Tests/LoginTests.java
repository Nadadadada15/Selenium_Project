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

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checkInputTypes() {
        navPage.clickOnLoginBtn();
        wait
                .withMessage("User Should Be on Login page")
                .until(ExpectedConditions.urlContains("/login"));

        Assert.assertEquals("email", logInPage.getEmailField().getAttribute("type"), "Actual value should be 'email'");
        Assert.assertEquals("password", logInPage.getPasswordField().getAttribute("type"), "Actual value should be 'password'");

    }





}
