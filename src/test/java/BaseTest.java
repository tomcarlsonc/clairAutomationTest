import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    WebDriver driver;

    @BeforeClass
    public void setupApplication()
    {

        Reporter.log("=====Browser Session Started=====", true);

        System.setProperty("webdriver.chrome.driver", "/Users/tomcarlson/Downloads/chromedriver");

        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

}
