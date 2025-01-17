import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ThreeclassTest {

    public static WebDriver driver; // Class-level driver

    @BeforeMethod
    public void launchDriver() {
        WebDriverManager.chromedriver().setup(); // Ensure setup() is called to configure the driver
        driver = new ChromeDriver(); // Initialize the class-level driver
        /*driver.get("https://www.google.com/");*/
        driver.manage().window().maximize();
    }

    @Test
    public void Test1() throws InterruptedException {
        driver.navigate().to("https://www.youtube.com/watch?v=o7V4ddxnCds"); // Navigate using the class-level driver
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public void Test2() throws InterruptedException {
        driver.navigate().to("https://www.google.com");
        Thread.sleep(1000);
    }

    @Test
    public void Test3() throws InterruptedException {
        driver.navigate().to("https://www.facebook.com/");
        Thread.sleep(1000);
    }

    @AfterMethod
    public void quit() {
        if (driver != null) {
            driver.quit(); // Quit the driver after each test
        }
    }
}
