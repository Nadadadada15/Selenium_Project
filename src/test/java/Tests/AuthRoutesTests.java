package Tests;

import Retry.RetryAnalyzer;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest{
    String baseUrl="https://vue-demo.daniel-avellaneda.com";
    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void forbidsVisitsToHomeUrlIfNotAuthenticated(){

        driver.navigate().to(baseUrl + "/home");
      Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login","Url should display '/login' path");

    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void forbidsVisitsToProfileUrlIfNotAuthenticated(){

        driver.navigate().to(baseUrl + "/profile");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "Url should display '/login' path");


    }

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated(){

        driver.navigate().to(baseUrl + "/admin/cities");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "Url should display '/login' path");


    }

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated(){

        driver.navigate().to(baseUrl + "/admin/users");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "Url should display '/login' path");


    }


}
