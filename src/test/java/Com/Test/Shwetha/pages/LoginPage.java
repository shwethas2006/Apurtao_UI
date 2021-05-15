package Com.Test.Shwetha.pages;

import Com.Test.Shwetha.SeleneseBase;
import Com.Test.Shwetha.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends SeleneseBase {

    SeleneseBase testContext;

    public LoginPage(SeleneseBase testContext, WebDriver driver) {
        this.testContext = testContext;
        this.driver = driver;
    }

    @FindBy(how = How.CLASS_NAME, using = "login")
    WebElement signInButton;

    @FindBy(how = How.ID, using = "email")
    WebElement emailAddress;

    @FindBy(how = How.ID, using = "passwd")
    WebElement password;

    @FindBy(how = How.CLASS_NAME, using = "home")
    WebElement myAccountPage;

    @FindBy(how = How.ID, using =  "SubmitLogin")
    WebElement loginButton;

    public void login(String username, String pwd) {
        signInButton.click();
        Utils.getWait(driver).until(ExpectedConditions.visibilityOf(emailAddress));
        emailAddress.sendKeys(username);
        password.sendKeys(pwd);
        loginButton.click();

    }

    public boolean checkHomePage() {
        return myAccountPage.isDisplayed();
    }

}


