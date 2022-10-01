import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SauceLabsTest {
    private final String BASE_URL = "https://www.saucedemo.com";
    private WebDriver webDriver;

    @BeforeSuite
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
    }
    @BeforeMethod
    public void beforeTest() {
        webDriver = new FirefoxDriver();
    }
    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }

    @Test
    public void goToHomePage() {
        webDriver.get(BASE_URL);
        webDriver.findElement(By.id("user-name")).sendKeys("standard_user");
        webDriver.findElement(By.id("password")).sendKeys("secret_sauce");
        webDriver.findElement(By.id("login-button")).click();
        final String title = webDriver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(title, "PRODUCTS");
    }
}
