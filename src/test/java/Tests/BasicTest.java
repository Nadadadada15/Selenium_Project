package Tests;

import Helpers.helpers;
import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;

public abstract class BasicTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected LogInPage logInPage;
    protected CitiesPage citiesPage;
    protected MessagePopUpPage messagePopUpPage;
    protected NavPage navPage;
    protected SignUpPage signUpPage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        logInPage = new LogInPage(driver, wait);
        citiesPage = new CitiesPage(driver, wait);
        messagePopUpPage = new MessagePopUpPage(driver, wait);
        navPage = new NavPage(driver, wait);
        signUpPage = new SignUpPage(driver, wait);


        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }


    @BeforeMethod
    public void beforeMethod() {
        String baseUrl = "https://vue-demo.daniel-avellaneda.com";
        driver.navigate().to(baseUrl);
    }


    @AfterMethod
    public void afterMethod(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            helpers.takeAScreenshot(driver, "Screenshots/failedSS " + result.getMethod().getMethodName() + ".jpg");
        }


        driver.manage().deleteAllCookies();
        ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}