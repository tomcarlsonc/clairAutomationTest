import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailPasswordPage {

    private WebDriver webDriver;
    private WebDriverWait wait;


    private By passwordField = By.cssSelector("#password >* input");
    private By nextButton = By.cssSelector("#passwordNext > div > button");
    private By wrongPassErrorMessage = By.cssSelector("#view_container >*  form > span > section > div > div > div:nth-child(4) > div:nth-child(2) > div:nth-child(2)");

    public GmailPasswordPage(WebDriver driver){
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 10);
    }

    public void enterTextIntoPasswordField(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        webDriver.findElement(passwordField).sendKeys(text);
    }

    public void clickNext() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nextButton));
        webDriver.findElement(nextButton).click();
    }

    public boolean isErrorMessageDisplayed(){
        return webDriver.findElement(wrongPassErrorMessage).isDisplayed();
    }
}
