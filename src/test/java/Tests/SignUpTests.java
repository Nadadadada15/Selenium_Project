package Tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class SignUpTests extends BasicTest {


    @Test
    public void verifySignUpPageUrl(){

        navPage.clickOnSignUpBtn();
        wait
                .withMessage("User Should Be on SignUp page")
                .until(ExpectedConditions.urlContains("/signup"));


    }

}
