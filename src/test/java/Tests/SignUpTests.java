package Tests;

import Retry.RetryAnalyzer;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;

public class SignUpTests extends BasicTest {


    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void verifySignUpPageUrl() {

        navPage.clickOnSignUpBtn();
        wait
                .withMessage("User Should Be on SignUp page")
                .until(ExpectedConditions.urlContains("/signup"));


    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
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

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void verifyUserAlreadyExistsPopUpMsg() {
        String nameInputData = "Another User";
        String emailInputData = "admin@admin.com";
        String passwordInputData = "12345";
        String confPasswordInputData = "12345";

        navPage.clickOnSignUpBtn();
        wait
                .withMessage("User Should Be on SignUp page")
                .until(ExpectedConditions.urlContains("/signup"));

        signUpPage.clearNameInputField();
        signUpPage.getNameInputField().sendKeys(nameInputData);


        signUpPage.clearEmailInputField();
        signUpPage.getEmailInputField().sendKeys(emailInputData);

        signUpPage.clearPasswordInputField();
        signUpPage.getPasswordInputField().sendKeys(passwordInputData);

        signUpPage.clearConfPasswordInputField();
        signUpPage.getConfPasswordInputField().sendKeys(confPasswordInputData);

        signUpPage.clickOnSignUpBtn();
        messagePopUpPage.waitUntilErrorMsgPopUpAppears();

        Assert.assertEquals(messagePopUpPage.getErrorMsgText(), "E-mail already exists", "Error message 'E-mail already exists' should appear'");

        wait
                .withMessage("User Should Be on SignUp page")
                .until(ExpectedConditions.urlContains("/signup"));

    }

    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void verifySignUp() {
        String nameInputData = "Nada Nikolic";
        String emailInputData = "nada.nikoli@itbootcamp.rs";
        String passwordInputData = "12345";
        String confPasswordInputData = "12345";

        navPage.clickOnSignUpBtn();
        wait
                .withMessage("User Should Be on SignUp page")
                .until(ExpectedConditions.urlContains("/signup"));

        signUpPage.clearNameInputField();
        signUpPage.getNameInputField().sendKeys(nameInputData);


        signUpPage.clearEmailInputField();
        signUpPage.getEmailInputField().sendKeys(emailInputData);

        signUpPage.clearPasswordInputField();
        signUpPage.getPasswordInputField().sendKeys(passwordInputData);

        signUpPage.clearConfPasswordInputField();
        signUpPage.getConfPasswordInputField().sendKeys(confPasswordInputData);

        signUpPage.clickOnSignUpBtn();

        wait
                .withMessage("User Should Be on SignUp page")
                .until(ExpectedConditions.urlContains("/home"));

        driver.navigate().refresh();

        messagePopUpPage.waitUntilVerifyAccountPopUpAppears();
        messagePopUpPage.isVerifyAccountPopUpTextCorrect();
        messagePopUpPage.clickOnCloseBtn();

        navPage.clickOnLogOutBtn();

        wait
                .withMessage("User Should Be on LogIn page")
                .until(ExpectedConditions.urlContains("/login"));


    }


}
