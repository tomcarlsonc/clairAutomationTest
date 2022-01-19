import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailHomepage {

    private WebDriver webDriver;
    private WebDriverWait wait;


    private By signInButton = By.cssSelector("body > header > div > div > div > a.button.button--medium.button--mobile-before-hero-only");

    public GmailHomepage(WebDriver driver){
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 10);
    }

    public void clickSignInButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInButton));
        webDriver.findElement(signInButton).click();
    }
}
