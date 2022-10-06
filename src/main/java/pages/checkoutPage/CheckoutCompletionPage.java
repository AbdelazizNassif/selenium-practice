package pages.checkoutPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutCompletionPage {

    private WebDriver driver;
    WebDriverWait wait;
    // constructor
    public CheckoutCompletionPage(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    private static final By ORDER_COMPLETION_HEADER = By.className("complete-header");
    private static final By ORDER_COMPLETION_TEXT = By.className("complete-text");

    public String getOrderCompletionHeader ()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ORDER_COMPLETION_HEADER));
        return driver.findElement(ORDER_COMPLETION_HEADER).getText() ;
    }
    public String getOrderCompletionText ()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ORDER_COMPLETION_TEXT));
        return driver.findElement(ORDER_COMPLETION_TEXT).getText() ;
    }


}
