package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends BasicPage {
    public SignUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public WebElement getNameInputField() {
        return driver.findElement(By.id("name"));
    }

    public void clickOnNameInputField() {
        getNameInputField().click();

    }

    public void clearNameInputField() {
        getNameInputField().clear();
    }
    public WebElement getEmailInputField() {
        return driver.findElement(By.id("email"));
    }

    public void clickOnEmailInputField() {
        getEmailInputField().click();

    }

    public void clearEmailInputField() {
        getEmailInputField().clear();
    }
    public WebElement getPasswordInputField() {
        return driver.findElement(By.id("password"));
    }

    public void clickOnPasswordInputField() {
        getPasswordInputField().click();

    }

    public void clearPasswordInputField() {
        getPasswordInputField().clear();
    }

    public WebElement getConfPasswordInputField() {
        return driver.findElement(By.id("confirmPassword"));
    }

    public void clickOnConfPasswordInputField() {
        getConfPasswordInputField().click();

    }

    public void clearConfPasswordInputField() {
        getConfPasswordInputField().clear();
    }

    public WebElement getSignUpBtn(){

        return driver.findElement(By.xpath("//button/span [text()= 'Sign me up']"));
    }

    public void clickOnSignUpBtn(){

        getSignUpBtn().click();
    }










}
