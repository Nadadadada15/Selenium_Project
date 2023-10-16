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

        Assert.assertEquals( logInPage.getEmailField().getAttribute("type"), "email","Actual value should be 'email'");
        Assert.assertEquals( logInPage.getPasswordField().getAttribute("type"), "password","Actual value should be 'password'");

    }

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void verifyErrorMsgsForNonExistantUsers(){
        String invalidEmail = "non-existing-user@gmal.com";
        String invalidPassword = "password123";

        navPage.clickOnLoginBtn();
        wait
                .withMessage("User Should Be on Login page")
                .until(ExpectedConditions.urlContains("/login"));



        logInPage.getEmailField().sendKeys(invalidEmail);
        logInPage.getPasswordField().sendKeys(invalidPassword);

        logInPage.clickOnLoginBtn();

        Assert.assertEquals(messagePopUpPage.getErrorMsgText(), "User does not exists", "Error message 'User does not exists' should appear");




    }

    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void verifyErrorMsgsForWrongPassword(){
        String email = "admin@admin.com";
        String invalidPassword = "password123";

        navPage.clickOnLoginBtn();
        wait
                .withMessage("User Should Be on Login page")
                .until(ExpectedConditions.urlContains("/login"));



        logInPage.getEmailField().sendKeys(email);
        logInPage.getPasswordField().sendKeys(invalidPassword);

        logInPage.clickOnLoginBtn();

        Assert.assertEquals(messagePopUpPage.getErrorMsgText(), "Wrong password", "Error message 'Wrong password' should appear");




    }

}
