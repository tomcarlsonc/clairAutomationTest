import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {


    private WebDriver webDriver;
    private WebDriverWait wait;


    private By searchInput = By.cssSelector("body > div > div:nth-child(3) > form > div > div > div:nth-child(3) >* input");
    private By gmailElement = By.cssSelector("#gb > div > div:nth-child(1) > div > div:nth-child(1) > a");

    public HomePage(WebDriver driver){
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 10);
    }

    public void enterTextAndSearch(String text){
        //wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput));
        webDriver.findElement(searchInput).sendKeys(text);
        webDriver.findElement(searchInput).sendKeys(Keys.RETURN);
    }

    public String getGmailElementText() {
        return webDriver.findElement(gmailElement).getText();
    }

    public void clickGmailLink() {
        webDriver.findElement(gmailElement).click();
    }
}
