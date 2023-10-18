package Tests;

import Retry.RetryAnalyzer;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
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


    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void  verifyCityInputTypeFromCreateEditPopUp(){
        String adminEmailInputData = "admin@admin.com";
        String passwordInputData = "12345";

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


        citiesPage.clickOnNewItem();
        citiesPage.waitUntilEditDialogueIsVisible();

        Assert.assertEquals(citiesPage.getNameInputFiledFromNewItemDialogue().getAttribute("type"),"text");

    }

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyAddNewCityFunctionality() throws InterruptedException {

        String adminEmailInputData = "admin@admin.com";
        String passwordInputData = "12345";
        String userCity="Nada's City";

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


        citiesPage.clickOnNewItem();
        citiesPage.waitUntilEditDialogueIsVisible();

        citiesPage.getNameInputFiledFromNewItemDialogue().clear();
        citiesPage.getNameInputFiledFromNewItemDialogue().sendKeys(userCity);
        citiesPage.clickOnSaveBtn();
        messagePopUpPage.waitUntilNewCityAddedPopUpIsVisible();



        Assert.assertEquals(messagePopUpPage.getNewCityAddedPopUpText().substring(0,18)
                ,"Saved successfully","Message PopUp should be 'Saved Successfully'");


    }
    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyEditNewCityFunctionality() throws InterruptedException {
        String adminEmailInputData = "admin@admin.com";
        String passwordInputData = "12345";
        String userCity="Nada's City";
        String userCityEdited= " Nada's City Edited";
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

        citiesPage.getSearchInput().sendKeys(userCity);

        Assert.assertTrue(citiesPage.verifyRowNumIsOne());

        citiesPage.clickOnEditBtn();

        wait
                .withMessage("Edit Dialogue should appear")
                .until(ExpectedConditions.visibilityOf(citiesPage.getEditDialogue()));
        citiesPage.getNameInputFiledFromNewItemDialogue().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));

        citiesPage.getNameInputFiledFromNewItemDialogue().sendKeys(userCityEdited);
        citiesPage.clickOnSaveBtn();
        messagePopUpPage.waitUntilNewCityAddedPopUpIsVisible();
        Assert.assertEquals(messagePopUpPage.getNewCityAddedPopUpText().substring(0,18)
                ,"Saved successfully","Message PopUp should be 'Saved Successfully'");


    }
    @Test(priority = 5, retryAnalyzer = RetryAnalyzer.class)
    public void verifySearchCityFunctionality() throws InterruptedException {
        String adminEmailInputData = "admin@admin.com";
        String passwordInputData = "12345";
        String userCity="Nada's City";

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


        citiesPage.getSearchInput().sendKeys(userCity);

        citiesPage.waitUntilRowNumIsOne();

       Assert.assertTrue(citiesPage.isNadasCityTableDataCorrect());


    }


}
