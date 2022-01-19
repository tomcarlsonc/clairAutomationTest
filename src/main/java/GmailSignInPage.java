import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailSignInPage {

    private WebDriver webDriver;
    private WebDriverWait wait;


    private By emailField = By.id("identifierId");
    private By nextButton = By.cssSelector("#identifierNext > div > button");

    public GmailSignInPage(WebDriver driver){
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 10);
    }

    public void enterTextIntoEmailField(String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        webDriver.findElement(emailField).sendKeys(text);
    }

    public void clickNext() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nextButton));
        webDriver.findElement(nextButton).click();
    }
}
