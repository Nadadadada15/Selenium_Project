package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage extends BasicPage {
    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public void waitUntilErrorMsgPopUpAppears() {

        wait.withMessage("Pup up should be visible").until(ExpectedConditions.visibilityOf(driver.findElement(By.className("v-snack__wrapper"))));
    }


    public WebElement getErrorMessagePopUp() {

        return driver.findElement(By.cssSelector("div.v-snack__content > ul > li"));
    }


    public String getErrorMsgText() {

        return getErrorMessagePopUp().getText();
    }


    public WebElement getVerifyAccount() {
        return driver.findElement(By.cssSelector(".v-card>div.v-card__title"));
    }

    public void waitUntilVerifyAccountPopUpAppears() {

        wait.withMessage("Verify account pop-up should be visible")
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".v-card>div.v-card__title"))));
    }


    public String getVerifyAccountPopUpText() {

        return getVerifyAccount().getText();
    }


    public boolean isVerifyAccountPopUpTextCorrect() {

        return getVerifyAccountPopUpText().equals("IMPORTANT: Verify your account");

    }

    public WebElement getCloseBtn() {

        return driver.findElement(By.className("btnClose"));
    }

    public void clickOnCloseBtn() {

        getCloseBtn().click();
    }

    public WebElement getNewCityAddedPopUp() {

        return driver.findElement(By.cssSelector(".v-sheet.success>div"));
    }

    public void waitUntilNewCityAddedPopUpIsVisible() {
        wait
                .withMessage("New City Added Message PopUp should be visible")
                .until(ExpectedConditions.visibilityOf(driver.
                        findElement(By.cssSelector(".v-sheet.success>div"))));

    }

    public String getNewCityAddedPopUpText(){

        return getNewCityAddedPopUp().getText();

    }


}









