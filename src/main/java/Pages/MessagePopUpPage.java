package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage extends BasicPage{
    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }



    public void waitUntilErrorMsgPopUpAppears(){

        wait.withMessage("Pup up should be visible")
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.className("v-snack__wrapper"))));
    }


    public WebElement getErrorMessagePopUp(){

        return  driver.findElement(By.cssSelector(" div.v-snack__content > ul > li"));
    }


    public String getErrorMsgText(){

        return getErrorMessagePopUp().getText();
    }



}









