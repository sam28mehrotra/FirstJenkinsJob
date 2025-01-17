import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FlipkartTest {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
    }

    @BeforeMethod
    public  void openbrowser() throws InterruptedException {

        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }
    @Test
    public void Navigate() throws  InterruptedException{
        WebElement object=driver.findElement(By.xpath("//a[@class='_1ch8e_']"));
        object.click();
        Thread.sleep(1000);
    }
    @AfterTest
    public  void tear(){
        driver.quit();
    }
}
