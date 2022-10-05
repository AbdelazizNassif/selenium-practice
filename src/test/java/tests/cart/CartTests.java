package tests.cart;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.cartPage.CartPage;
import pages.homePage.HomePage;
import tests.TestBase;

public class CartTests extends TestBase {
    protected ThreadLocal<HomePage> homePage = new ThreadLocal<>();
private SoftAssert softAssert = null;
    // test data
    private String backpackTitle_homePage;
    private String backpackDescription_homePage;
    private String backpackPrice_homePage;

    @BeforeMethod
    public void setupCartTests ()
    {
        softAssert = new SoftAssert();
        homePage.set(loginPage.get().loginToApp("standard_user", "secret_sauce")) ;
    }

    @Test(priority = 1)
    public void checkTheDataOfTheBackpack () {
        backpackTitle_homePage = homePage.get().getBackpackTitle();
        softAssert.assertEquals(backpackTitle_homePage, "Sauce Labs Backpack");
        backpackDescription_homePage = homePage.get().getBackpackDescription();
        softAssert.assertTrue(backpackDescription_homePage.contains("laptop and tablet protection."), "Sauce Labs Backpack");
        backpackPrice_homePage = homePage.get().getBackpackPrice();
        softAssert.assertEquals(backpackPrice_homePage, "$29.99");
        softAssert.assertAll("Some of Cart assertions are not as expected");
    }
    @Test (priority = 2)
    public void clickAddItemsToCartThenCheckExistenceOfRemoveButton () {
        homePage.get().addBackpackToCart();
        softAssert.assertTrue(homePage.get().isRemoveButtonDisplayed(),
                "The remove from card button should be displayed");
        homePage.get().clickRemoveBackpackButton();
        softAssert.assertTrue(homePage.get().isAddToCartButtonDisplayed(),
                "The add to cart button should be displayed");
        softAssert.assertAll("Some of Cart assertions are not as expected");
    }

    @Test (priority = 3)
    public void checkThatTheItemsAddedWillReflectOnTheShoppingCart () {
        homePage.get().addBackpackToCart();
        softAssert.assertEquals(homePage.get().getNumberOfItemsAddedToTheCard(), "1",
                "The number of items added should be only 1");
        CartPage cartPage = homePage.get().clickShoppingCartLink() ;
        softAssert.assertEquals(cartPage.getQuantityOfAddedItems(1), "1",
                "The quantity of items should be only 1");
        softAssert.assertEquals(cartPage.getDescriptionOfAddedItems(1),
                "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.");
        softAssert.assertEquals(cartPage.getTitleOfAddedItems(1), "Sauce Labs Backpack");
        softAssert.assertEquals(cartPage.getPriceOfAddedItems(1), "$29.99");
        softAssert.assertAll("Some of Cart assertions are not as expected");
    }
}
