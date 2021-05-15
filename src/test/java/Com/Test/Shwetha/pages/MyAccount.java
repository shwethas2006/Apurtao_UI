package Com.Test.Shwetha.pages;

import Com.Test.Shwetha.SeleneseBase;
import Com.Test.Shwetha.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MyAccount extends SeleneseBase {

    SeleneseBase testContext;

    public MyAccount(SeleneseBase testContext, WebDriver driver) {
        this.testContext = testContext;
        this.driver = driver;
    }

    @FindBy(how = How.CSS, using = "a[title='Orders']")
    WebElement ordersLink;

    @FindBy(how = How.CSS, using = "a[title='Information']")
    WebElement personalInformation;

    @FindBy(how = How.ID, using = "firstname")
    WebElement firstNameTextField;

    @FindBy(how = How.ID, using = "old_passwd")
    WebElement oldPassword;

    @FindBy(how = How.XPATH, using = "//ul[contains(@class,'sf-menu')]/li[3]")
    WebElement tShirtTab;

    @FindBy(how = How.CSS, using = "a[title='View my customer account']")
    WebElement clickOnMyAccount;

    @FindBy(how = How.NAME, using = "submitIdentity")
    WebElement saveButton;

    @FindBy(how = How.CSS, using = "[class*='alert-success']")
    WebElement alertMessage;


    public void enterFirstNameandSave(String firstName, String pwd) {
        firstNameTextField.clear();
        firstNameTextField.sendKeys(firstName);
        oldPassword.sendKeys(pwd);
    }

    public void clickSave() {
        saveButton.click();
    }

    public boolean checkPersonalInformationAlert() {

        return alertMessage.getText().contains("successfully updated");
    }

    public void clickOnTshirts() {

        tShirtTab.click();
    }

    public void navigateToMyAccountsPage() {

        clickOnMyAccount.click();
    }

    public void clickOnOrdersHistoryDetails() {
        ordersLink.click();
        WebElement ele = Utils.findElementContainingTextUsingXpath(driver, "Order history");
       // Utils.getWait(driver).until(ExpectedConditions.visibilityOf(ele));

    }

    public void clickOnPersonalInformation()
    {
        personalInformation.click();
        Utils.getWait(driver).until(ExpectedConditions.visibilityOf(firstNameTextField));

    }

    public void modifyFirstName(String name)
    {
        firstNameTextField.sendKeys(name);
    }

    public boolean verifyAlertMsg()
    {
        return alertMessage.getText().contains("successfully updated.");
    }



}

