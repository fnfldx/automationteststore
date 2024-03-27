package temporary.tests;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.LoginPage;

import static engine.drivers.WebDriverFactory.quitWebDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static steps.BaseSteps.*;
import static steps.CartPageSteps.goToCheckout;
import static steps.CartPageSteps.updateCart;
import static steps.LoginPageSteps.goToAccountLogin;
import static steps.LoginPageSteps.proceedAsGuest;

public class TestGuestCheckout extends BaseTest {

    protected static LoginPage loginPage;

    @BeforeClass
    public static void setUp() {
        loginPage = new LoginPage();
    }

    @After
    public void tearDown() {
        quitWebDriver();
    }

    @Test
    public void continueAsGuest() {
        // Given:
        openPage();
        addToCart();
        goToCart();
        updateCart();
        goToCheckout();

        // When:
        proceedAsGuest();

        // Then:
        validateURL("https://automationteststore.com/index.php?rt=checkout/guest_step_1");
    }

    @Test
    public void proceedToLoginOrRegister() {
        // Given:
        openPage();

        // When:
        goToAccountLogin();

        // Then:
        assertThat(loginPage.isGuestCheckoutButtonVisible()).isFalse();
    }
}