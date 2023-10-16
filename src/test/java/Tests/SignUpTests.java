package Tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;

public class SignUpTests extends BasicTest {


    @Test(priority = 1, retryAnalyzer = IRetryAnalyzer.class)
    public void verifySignUpPageUrl() {

        navPage.clickOnSignUpBtn();
        wait
                .withMessage("User Should Be on SignUp page")
                .until(ExpectedConditions.urlContains("/signup"));


    }

    @Test (priority = 2,retryAnalyzer = IRetryAnalyzer.class)
    public void checkInputTypes() {
        navPage.clickOnSignUpBtn();
        wait
                .withMessage("User Should Be on SignUp page")
                .until(ExpectedConditions.urlContains("/signup"));

        Assert.assertEquals(signUpPage.getNameInputField().getAttribute("type"), "text");
        Assert.assertEquals(signUpPage.getEmailInputField().getAttribute("type"), "email");
        Assert.assertEquals(signUpPage.getPasswordInputField().getAttribute("type"), "password");
        Assert.assertEquals(signUpPage.getConfPasswordInputField().getAttribute("type"), "password");

    }



}
