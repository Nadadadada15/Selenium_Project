package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
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

        return driver.findElement(By.className("dlgNewEditItem")); //.dlgNewEditItem
    }


    public void waitUntilEditDialogueIsVisible() {
        wait.
                until(ExpectedConditions.visibilityOf(getEditDialogue()));

    }

    public WebElement getNameInputFiledFromNewItemDialogue() {
        return driver.findElement(By.cssSelector("input#name"));

    }

    public void clickOnNameInputFiledFromNewItemDialogue() {

        getNameInputFiledFromNewItemDialogue().click();
    }


    public WebElement getSaveBtn() {

        return driver.findElement(By.className("btnSave"));
    }

    public void clickOnSaveBtn() {

        getSaveBtn().click();
    }


    List<WebElement> deleteIcons = driver.findElements(By.id("delete"));
    List<WebElement> tableRows = driver.findElements(By.cssSelector("tbody tr"));


    public Integer citiesRowNumber() {
        int counter = 0;
        for (int i = 0; i < tableRows.size(); i++) {
            counter++;
        }
        return counter;
    }

    public boolean verifyRowNumIsOne() {
        if (citiesRowNumber() > 1 && citiesRowNumber() < 1) {
            return false;
        }
        return true;
    }


    public WebElement getEditBtn() {

        return driver.findElement(By.id("edit"));
    }

    public void clickOnEditBtn() {
        getEditBtn().click();
    }


    public String getNadasCityTableDataText() {

        List<WebElement> searchedRows = driver.findElements(By.cssSelector("tbody tr"));
        String cityNameData = null;

        for (int i = 0; i < searchedRows.size(); i++) {

            cityNameData = searchedRows.get(i).findElement(By.cssSelector(".text-left:nth-child(2)")).getText();

        }
        return cityNameData;

    }

    public boolean isNadasCityTableDataCorrect(){

        return getNadasCityTableDataText().contains("Nada's City");
    }

    public void waitUntilRowNumIsOne(){

        wait
                .withMessage("Table rows should be one")
                .until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("tbody tr .text-left:nth-child(2)"),1));
    }


    public void waitUntilSearchBarIsNotEmpty(){

        wait
                .withMessage("Search bar should not be empty")
                .until(ExpectedConditions.textToBe(By.id("search"),"Nada's City"));
    }


    //.v-dialog__content--active > div > div za new item pop up


}
