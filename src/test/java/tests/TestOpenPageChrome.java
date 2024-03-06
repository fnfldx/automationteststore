package tests;

import engine.drivers.WebDriverFactory;
import enums.BrowserName;
import enums.NavbarButton;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;
import utils.ShoppingCartTable;

import java.time.Duration;

import static engine.property.manager.PropertyManager.PropertyKeys.BASE_URL;
import static engine.property.manager.PropertyManager.getProperty;
import static engine.property.manager.PropertyManager.getPropertyManagerInstance;

public class TestOpenPageChrome {
    @Test
    public void openPage() {
        getPropertyManagerInstance();
        WebDriver driver = WebDriverFactory.getWebDriver(BrowserName.CHROME);

        String url = getProperty(BASE_URL);
        driver.navigate().to(url);

        var welcomeMsg = By.xpath("//div[@class='welcome_msg']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMsg));

        Assert.assertEquals(url, driver.getCurrentUrl());

        driver.quit();
    }

    @Test
    public void TestForShoppingCart() {
        System.out.println("This is a test for debugging");
        getPropertyManagerInstance();
        WebDriver driver = WebDriverFactory.getWebDriver(BrowserName.CHROME);

        String url = getProperty(BASE_URL);
        driver.navigate().to(url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //TESTING BY DEBUG SHOPPING CART TABLE CLASS
        var basePage = new BasePage(driver);
        var cartTable = new ShoppingCartTable(driver);
        basePage.clickOnElement(By.xpath("//a[@data-id=50]"));
        basePage.clickOnElement(By.xpath("//a[@data-id=68]"));
        basePage.clickOnElement(By.xpath("//a[@data-id=65]"));
        var cartButton = basePage.buttonNavbarLocatorByDataId(NavbarButton.CART);
        basePage.clickOnElement(cartButton);

        int debug1 = cartTable.getRowCount();
        int debug2 = cartTable.getColumnCount();
        int debug3 = cartTable.getColumnIndex("Name");
        var debug4 = cartTable.getColumnHeaders();
        var debug5 = cartTable.getRowIndex("Benefit Bella Bamba");
        var debug6 = cartTable.getRowNumber("Benefit Bella Bamba");
        var debug7 = cartTable.getRowContent(2);
        var debug8 = cartTable.getColumnContent(1); //links from img
        var debug8a = cartTable.getColumnContent(2);//names
        var debug8b = cartTable.getColumnContent(3);//models
        var debug8c = cartTable.getColumnContent(4);//price
        var debug8d = cartTable.getColumnContent(5);//quantity
        var debug8e = cartTable.getColumnContent(6);//sum price
        var debug8f = cartTable.getColumnContent(7);//delete button href
        var debug9 = cartTable.getColumnContent("Quantity");
        var debug10 = cartTable.getCellContent(3, 3);
        var debug11 = cartTable.getCellContent(3, "Name");

        var debug12 = cartTable.getUnitPriceWithCurrencyCharacter(1);
        var debug13 = cartTable.getUnitPrice(1);
        var debug14 = cartTable.getTotalPriceWithCurrencyCharacter(1);
        var debug15 = cartTable.getTotalPrice(1);
        var debug16 = cartTable.getQuantity(1);

        cartTable.setQuantity(3, 10);
        cartTable.deleteItem(2);
        driver.quit();
    }
}