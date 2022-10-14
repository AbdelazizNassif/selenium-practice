package tests;

import driverSettigns.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.login.LoginPage;

public class TestBase {
    // todo browser stack + jenkins pipeline + Driver factory + send report as post action in github actions
    // todo cucumber
    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected ThreadLocal<LoginPage> loginPage = new ThreadLocal<>();

    @BeforeMethod
    public void setup () {
        driver.set(DriverFactory.getDriver()) ;
        // start of application
        loginPage.set(new LoginPage(driver.get()));
        loginPage.get().navigate();
        driver.get().manage().window().maximize();
    }

    @AfterMethod
    public void teardown ()
    {
        driver.get().quit();
        // psuh on master 
    }
}
