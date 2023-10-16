package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage extends BasicPage {
    public LogInPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //WebElements

    public WebElement getEmailField() {
        return driver.findElement(By.id("email"));
    }
    public WebElement getPasswordField() {
        return driver.findElement(By.id("password"));

    }

    public WebElement getLoginBtn(){
        return driver.findElement(By.xpath("//button[@type='submit']"));
    }

}
