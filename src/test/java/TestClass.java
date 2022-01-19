import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass extends BaseTest {

//    public WebDriver driver;
    public HomePage homePage;
    public GmailHomepage gmailHomepage;
    public GmailSignInPage gmailSignInPage;
    public GmailPasswordPage gmailPasswordPage;
    String baseURL = "https://www.google.com/";

    @Test
    void googleSearch() throws Exception {
        driver.get(baseURL);
        homePage = new HomePage(driver);
        homePage.enterTextAndSearch("selenium java");
        Assert.assertTrue(driver.getCurrentUrl().contains("www.google.com/search?q=selenium+java"));
        driver.quit();
    }

    @Test
    void validateHomepageTitle() throws Exception {

        driver.get(baseURL);
        homePage = new HomePage(driver);
        Assert.assertEquals(driver.getTitle(), "Google");
        driver.quit();
    }

    @Test
    void validateGmailText() throws Exception {

        driver.get(baseURL);
        homePage = new HomePage(driver);
        String gmailText = homePage.getGmailElementText();
        Assert.assertEquals(gmailText, "Gmail");
        driver.quit();
    }

    @Test
    void invalidCredsTest() throws Exception {

        driver.get(baseURL);
        homePage = new HomePage(driver);
        homePage.clickGmailLink();
        gmailHomepage = new GmailHomepage(driver);
        gmailHomepage.clickSignInButton();
        gmailSignInPage = new GmailSignInPage(driver);
        gmailSignInPage.enterTextIntoEmailField("aaaaa");
        gmailSignInPage.clickNext();
        gmailPasswordPage = new GmailPasswordPage(driver);
        gmailPasswordPage.enterTextIntoPasswordField("aaaaa");
        gmailPasswordPage.clickNext();
        Assert.assertTrue(gmailPasswordPage.isErrorMessageDisplayed());
        driver.quit();
    }

}
