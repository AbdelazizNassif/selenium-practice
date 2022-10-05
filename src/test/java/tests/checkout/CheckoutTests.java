package tests.checkout;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.checkoutPage.CheckoutCompletionPage;
import pages.checkoutPage.CheckoutOverviewPage;
import pages.checkoutPage.CheckoutPage;
import pages.cartPage.CartPage;
import pages.homePage.HomePage;
import pages.login.LoginPage;
import tests.TestBase;

import static filesReaders.ReadFromFiles.getJsonStringValueByKey;
import static filesReaders.ReadFromFiles.getPropertyByKey;

public class CheckoutTests extends TestBase {
    private ThreadLocal<HomePage> homePage = new ThreadLocal<>();

    private SoftAssert softAssert = null;

    String fName;
    String lName;
    String zipCode;


    @BeforeClass
    public void setup_setTestData() {
        String checkoutTestDataFileName = "checkoutTestData.json";
        fName = getJsonStringValueByKey(checkoutTestDataFileName, "firstname");
        lName = getJsonStringValueByKey(checkoutTestDataFileName, "lastname");
        zipCode = getJsonStringValueByKey(checkoutTestDataFileName, "zipcode");
    }

    @BeforeMethod
    public void setupCheckoutTests() {
        softAssert = new SoftAssert();
        homePage.set(loginPage.get().loginToApp(getPropertyByKey("environment.properties", "USER_NAME")
                , getPropertyByKey("environment.properties", "PASSWORD")));
    }

    @Test
    public void testCheckoutToCompleteTheOrder() {
        homePage.get().addBackpackToCart();
        CartPage cartPage = homePage.get().clickShoppingCartLink();
        CheckoutPage checkoutPage = cartPage.clickCheckoutButton();
        CheckoutOverviewPage checkoutOverviewPage =
                checkoutPage.fillCheckoutFormThenClickContinue(fName, lName, zipCode);
        CheckoutCompletionPage checkoutCompletionPage = checkoutOverviewPage.clickFinishButton();
        softAssert.assertEquals(checkoutCompletionPage.getOrderCompletionHeader(),
                "THANK YOU FOR YOUR ORDER");
        softAssert.assertEquals(checkoutCompletionPage.getOrderCompletionText(),
                "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
        softAssert.assertAll("Some of Checkout assertions are not as expected");
    }

    @Test
    public void testCheckoutToCompleteTheOrder2() {
        homePage.get().addBackpackToCart();
        CartPage cartPage = homePage.get().clickShoppingCartLink();
        CheckoutPage checkoutPage = cartPage.clickCheckoutButton();
        CheckoutOverviewPage checkoutOverviewPage =
                checkoutPage.fillCheckoutFormThenClickContinue(fName, lName, zipCode);
        CheckoutCompletionPage checkoutCompletionPage = checkoutOverviewPage.clickFinishButton();
        softAssert.assertEquals(checkoutCompletionPage.getOrderCompletionHeader(),
                "THANK YOU FOR YOUR ORDER");
        softAssert.assertEquals(checkoutCompletionPage.getOrderCompletionText(),
                "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
        softAssert.assertAll("Some of Checkout assertions are not as expected");
    }

    @Test
    public void testCheckoutToCompleteTheOrder22() {
        homePage.get().addBackpackToCart();
        CartPage cartPage = homePage.get().clickShoppingCartLink();
        CheckoutPage checkoutPage = cartPage.clickCheckoutButton();
        CheckoutOverviewPage checkoutOverviewPage =
                checkoutPage.fillCheckoutFormThenClickContinue(fName, lName, zipCode);
        CheckoutCompletionPage checkoutCompletionPage = checkoutOverviewPage.clickFinishButton();
        softAssert.assertEquals(checkoutCompletionPage.getOrderCompletionHeader(),
                "THANK YOU FOR YOUR ORDER");
        softAssert.assertEquals(checkoutCompletionPage.getOrderCompletionText(),
                "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
        softAssert.assertAll("Some of Checkout assertions are not as expected");
    }

}
