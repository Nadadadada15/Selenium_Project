package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class NavPage extends BasicPage {
    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    //WebElements
    public WebElement getLangBtn() {
        return driver.findElement(By.cssSelector("button.btnLocaleActivation"));
    }

    public void clickOnLangBtn() {

        getLangBtn().click();
    }

    public WebElement getEngLangLink() {

        return driver.findElement(By.cssSelector("div.v-menu__content>div>div:nth-child(1)"));
    }

    public void clickOnEngLangLink() {

        getEngLangLink().click();
    }

    List<WebElement> languages = driver.findElements(By.cssSelector("div.v-menu__content>div>div"));

    public WebElement getLoginBtn() {

        return driver.findElement(By.cssSelector("a[href='/login'] span.v-btn__content"));
    }

    public void clickOnLoginBtn() {

        getLoginBtn().click();
    }


    public WebElement getAboutBtn() {

        return driver.findElement(By.xpath("//*[@class='v-toolbar__items']/a[2]"));
    }

    public WebElement getSignUpBtn() {

        return driver.findElement(By.xpath("//*[@class='v-toolbar__items']/a[4]"));
    }

    public void clickOnSignUpBtn() {

        getSignUpBtn().click();
    }

    public WebElement getLogOutBtn() {
        return driver.findElement(By.cssSelector(".v-toolbar__items>button.btnLogout"));

    }

    public void clickOnLogOutBtn() {

        getLogOutBtn().click();
    }

    public boolean doesLogOutBtnExist() {

        return elementExists(By.cssSelector(".v-toolbar__items>button.btnLogout"));
    }


}
