package temporary.tests;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.cartPage.CartPage;
import steps.BaseSteps;

import static engine.drivers.WebDriverFactory.quitWebDriver;
import static steps.BaseSteps.*;
import static steps.CartPageSteps.goToCheckout;

public class TestCartPage extends BaseTest {

    protected static CartPage cartPage;

    @BeforeClass
    public static void setUp() {
        cartPage = new CartPage();
    }

    @After
    public void tearDown() {
        quitWebDriver();
    }

    @Test
    public void proceedToCheckout() {
        // Given:
        openPage();
        addToCart();
        goToCart();

        // When:
        goToCheckout();

        // Then:
        BaseSteps.validateURL("https://automationteststore.com/index.php?rt=account/login");
    }

}

