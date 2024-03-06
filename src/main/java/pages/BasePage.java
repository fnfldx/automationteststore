package pages;

import engine.property.manager.PropertyManager;
import enums.CategoryMenuButton;
import enums.FooterHyperLink;
import enums.NavbarButton;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl;

    protected final String navbarXpath = "//div[@role='navigation']";
    protected final String categoryMenuXpath = "//section[@id='categorymenu']";
    protected final String footersocialXpath = "//section[@class='footersocial']";
    protected final String footerlinksXpath = "//section[@class='footerlinks']";
    public By searchInputLocator = By.id("filter_keyword");
    public By searchButtonLocator = By.xpath("//i[@class='fa fa-search']");
    public By loginAndRegisterButtonLocator = By.xpath("//div[@class='navbar']//a");
    public By homeLinkByLogoLocator = By.xpath("//a[@class='logo']");
    public By currencyDropdownLocator = By.xpath("//ul[contains(@class, 'currency')]/parent::*");
    public By itemsInCartDropDownLocator = By.xpath("//ul[contains(@class, 'topcartopen')]/parent::*");
    public By newsletterInputLocator = By.xpath(footersocialXpath + "//input[@id='appendedInputButton']");
    public By newsletterButtonLocator = By.xpath(footersocialXpath + "//button[@class='btn btn-orange']");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        int baseWaitInSeconds = Integer.parseInt(PropertyManager.getProperty(PropertyManager.PropertyKeys.BASE_WAIT_IN_SECONDS));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(baseWaitInSeconds));
        this.baseUrl = PropertyManager.getProperty(PropertyManager.PropertyKeys.BASE_URL);
    }

    public By buttonNavbarLocatorByDataId(NavbarButton button) {
        return By.xpath(navbarXpath + "//li[@data-id='"+ button.getDataId() +"']//span[@class='menu_text']");
    }

    public By buttonCategoryMenuLocatorByText(CategoryMenuButton button) {
        return By.xpath(categoryMenuXpath + "//a[contains(text(), '" + button.getText() + "')]");
    }

    public By hyperLinkFooterLocatorByText(FooterHyperLink link) {
        return By.xpath(footerlinksXpath + "//a[text()='" + link.getText() + "']");
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public void clickOnElement(By locator) {
        locateElement(locator).click();
    }

    public void scrollToElement(By locator) {
        WebElement element = locateElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void hoverOverElement(By locator) {
        WebElement element = locateElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void selectCheckbox(By locator) {
        WebElement element = locateElement(locator);
        if (element.isSelected()) {
            throw new IllegalStateException("Checkbox is already selected");
        }
        element.click();
    }

    public void unselectCheckbox(By locator) {
        WebElement element = locateElement(locator);
        if (!element.isSelected()) {
            throw new IllegalStateException("Checkbox is already unselected");
        }
        element.click();
    }

    public void selectRadioButton(By locator) {
        WebElement element = locateElement(locator);
        if (element.isSelected()) {
            throw new IllegalStateException("Radio button is already selected");
        }
        element.click();
    }

    public void setCheckboxState(By locator, boolean state) {
        WebElement element = locateElement(locator);
        if (element.isSelected() == state) {
            throw new IllegalStateException("Checkbox is already in the desired state");
        }
        element.click();
    }

    public void enterTextToElement(By locator, String text) {
        locateElement(locator).sendKeys(text);
    }

    public String getTextFromElement(By locator) {
        return locateElement(locator).getText();
    }

    public String getValueFromElement(By locator) {
        return locateElement(locator).getAttribute("value");
    }

    public void clearTextFromElement(By locator) {
        locateElement(locator).clear();
    }
    public void clearAndTypeTextToElement(By locator, String text) {
        clearTextFromElement(locator);
        enterTextToElement(locator, text);
    }

    public boolean isElementDisplayed(By locator) {
        return !driver.findElements(locator).isEmpty() && driver.findElement(locator).isDisplayed();
    }

    public boolean isElementDisplayedAfterWait(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
    }

    protected WebElement locateElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }
}