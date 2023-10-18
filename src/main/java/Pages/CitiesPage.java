package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CitiesPage extends BasicPage {
    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public WebElement getNewItem() {

        return driver.findElement(By.className("btnNewItem"));
    }

    public void clickOnNewItem() {

        getNewItem().click();
    }


    public WebElement getSearchInput() {

        return driver.findElement(By.id("search"));
    }


    public WebElement getEditDialogue() {

        return driver.findElement(By.className("dlgNewEditItem"));
    }


    public void waitUntilEditDialogueIsVisible() {
        wait.
                until(ExpectedConditions.visibilityOf(getEditDialogue()));

    }

    public WebElement getNameInputFiledFromNewItemDialogue(){
        return driver.findElement(By.cssSelector("input#name"));

    }

    public void clickOnNameInputFiledFromNewItemDialogue(){

        getNameInputFiledFromNewItemDialogue().click();
    }



    public WebElement getSaveBtn() {

        return driver.findElement(By.className("btnSave"));
    }

    public void clickOnSaveBtn() {

        getSaveBtn().click();
    }


    List<WebElement> deleteIcons=driver.findElements(By.id("delete"));
    List<WebElement>tableRows = driver.findElements(By.cssSelector("tbody>tr"));


    //.v-dialog__content--active > div > div za new item pop up




}
