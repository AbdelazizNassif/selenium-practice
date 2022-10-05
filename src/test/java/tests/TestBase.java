package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.login.LoginPage;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {
    // todo browser stack + jenkins pipeline
    // next steps: docker compose (done) + github actions (done)+ run from cmd (done)
    // jenkins pipeline + + property file + json file
    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected ThreadLocal<LoginPage> loginPage = new ThreadLocal<>();
    boolean localEnvironment = true;
    @BeforeMethod
    public void setup () throws MalformedURLException {
        if (localEnvironment) {
            WebDriverManager.chromedriver().setup() ;
            driver.set(new ChromeDriver());
        }
        else {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setBrowserName("chrome");
            caps.setPlatform(Platform.LINUX);
            driver.set(new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), caps));
        }
        loginPage.set(new LoginPage(driver.get()));
        loginPage.get().navigate();
        driver.get().manage().window().maximize();
    }

    @AfterMethod
    public void teardown ()
    {
        driver.get().quit();
    }
}
