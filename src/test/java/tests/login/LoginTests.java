package tests.login;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.homePage.HomePage;
import tests.TestBase;

public class LoginTests extends TestBase {
    private ThreadLocal<HomePage> homePage = new ThreadLocal<>();
    private SoftAssert softAssert = null;

    @BeforeMethod
    public void setupLoginTests ()
    {
        softAssert = new SoftAssert();
        homePage.set(loginPage.get().loginToApp("standard_user", "secret_sauce")) ;
    }

    @Test(description = "Test Valid Login With Std Credentials")
    public void testLoginAsStandardUserWithValidCredentials() {

        softAssert.assertTrue(homePage.get().isAppPrimaryHeaderContentsDisplayed(),
                "The Logo is supposed to be displayed");
        softAssert.assertEquals(homePage.get().getAppSecondaryHeaderTitle(), "PRODUCTS",
                "The title should be PRODUCTS");
        softAssert.assertEquals(homePage.get().getInitialNumberOfDisplayedProducts(), 6,
                "The page should display 6 products initially");
        softAssert.assertAll("Some Login assertion are not as expected");
    }
    @Test(description = "Test Valid Login With Std Credentials")
    public void testLoginAsStandardUserWithValidCredentials2() {
        softAssert.assertTrue(homePage.get().isAppPrimaryHeaderContentsDisplayed(),
                "The Logo is supposed to be displayed");
        softAssert.assertEquals(homePage.get().getAppSecondaryHeaderTitle(), "PRODUCTS",
                "The title should be PRODUCTS");
        softAssert.assertEquals(homePage.get().getInitialNumberOfDisplayedProducts(), 6,
                "The page should display 6 products initially");
        softAssert.assertAll("Some Login assertion are not as expected");
    }
    @Test(description = "Test Valid Login With Std Credentials")
    public void testLoginAsStandardUserWithValidCredentials3() {
        softAssert.assertTrue(homePage.get().isAppPrimaryHeaderContentsDisplayed(),
                "The Logo is supposed to be displayed");
        softAssert.assertEquals(homePage.get().getAppSecondaryHeaderTitle(), "PRODUCTS",
                "The title should be PRODUCTS");
        softAssert.assertEquals(homePage.get().getInitialNumberOfDisplayedProducts(), 6,
                "The page should display 6 products initially");
        softAssert.assertAll("Some Login assertion are not as expected");
    }


}
