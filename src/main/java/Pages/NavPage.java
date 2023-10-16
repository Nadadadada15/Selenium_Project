package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasicPage{
    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    //WebElements
    public WebElement getLangBtn() {
        return driver.findElement(By.cssSelector("button.btnLocaleActivation"));
    }

    public WebElement getLoginBtn() {

        return driver.findElement(By.xpath("//*[@class='v-toolbar__items']/a[3]"));
    }

    public void clickOnLoginBtn(){

        getLoginBtn().click();
    }


    public WebElement getAboutBtn() {

        return driver.findElement(By.xpath("//*[@class='v-toolbar__items']/a[2]"));
    }

    public WebElement getSignUpBtn() {

        return driver.findElement(By.xpath("//*[@class='v-toolbar__items']/a[4]"));
    }






}
