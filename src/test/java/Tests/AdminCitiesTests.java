package Tests;

import Retry.RetryAnalyzer;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest {

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void verifyAdminPageUrl() {

        String adminNameInputData = "Admin";
        String adminEmailInputData = "admin@admin.com";
        String passwordInputData = "12345";
        String confPasswordInputData = "12345";


        navPage.clickOnLoginBtn();


        logInPage.getEmailField().sendKeys(adminEmailInputData);
        logInPage.getPasswordField().sendKeys(passwordInputData);

        wait
                .withMessage("User Should Be on Login page")
                .until(ExpectedConditions.urlContains("/login"));


        logInPage.clickOnLoginBtn();

        wait
                .withMessage("User Should Be on SignUp page")
                .until(ExpectedConditions.urlContains("/home"));


        navPage.clickOnAdminBtn();
        navPage.clickOnCitiesDropdownOptin();


        wait
                .withMessage("User Should Be on Admin page")
                .until(ExpectedConditions.urlContains("/admin/cities"));


    }


}
