package steps;


import org.openqa.selenium.By;
import pages.LoginPage;

import static engine.drivers.WebDriverFactory.getWebDriverInstance;

public class LoginPageSteps {

    protected static LoginPage loginPage;

    public static void proceedAsGuest() {
        loginPage = new LoginPage();
        loginPage.selectGuestAccountOption();
        loginPage.clickContinueButton();
    }

    public static void goToAccountLogin() {
        var loginOrRegister = getWebDriverInstance().findElement(By.id("customer_menu_top"));
        loginOrRegister.click();
    }
}
