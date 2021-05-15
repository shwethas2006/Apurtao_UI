package Com.Test.Shwetha.stepdefs;

import Com.Test.Shwetha.SeleneseBase;
import Com.Test.Shwetha.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class TestSteps extends SeleneseBase {


    SeleneseBase testContext;
    String uniqueString;

    public TestSteps(SeleneseBase testContext) {
        this.testContext = testContext;
        driver = testContext.getDriver();
        environmentProperties = testContext.getEnvironmentProperties();

        setupPageObjects();
    }

    public void setupPageObjects() {
        testContext.initializePageObjects(driver);
        loginPage = testContext.getLoginPage();
        myAccount = testContext.getMyAccount();
        orderPages = testContext.getOrderPages();
        orderHistory = testContext.getOrderHistory();

    }


    @Then("Login with username {string} and {string} and login")
    public void adminLoginWithUsernameAndAndLogin(String email, String password) {
        loginPage.login(getEnvironmentProperties().getProperty(email), getEnvironmentProperties().getProperty(password));

    }

    @Given("I am on MyAccount Page")
    public void iAmOnMyAccountPage() {
        loginPage.checkHomePage();

    }

    @And("I click on T-SHIRTS")
    public void iClickOnTSHIRTS() {
        myAccount.clickOnTshirts();
    }

    @And("I select tshirt size small")
    public void iSelectTshirtSize() {
        orderPages.selectTshirtSizeSmall();
    }

    @And("I click on Add to cart")
    public void iClickOnAddToCart() {
        orderPages.clickOnAddToCart();
    }

    @And("I click to proceed to checkout")
    public void iClickToProceedToCheckout() {

        orderPages.clickOnProceed();
    }

    @And("I click to proceed to checkout on address page")
    public void iClickToProceedToCheckoutOnAddressPage() throws InterruptedException {
        Thread.sleep(2000);
        orderPages.clickToProceedAddress.click();
    }

    @And("I click to proceed to checkout on summary page")
    public void iClickToProceedToCheckoutOnSummaryPage() throws InterruptedException {
        Thread.sleep(2000);
        orderPages.clickToProceedSummary.click();
    }

    @And("I click to proceed to checkout on popup window")
    public void iClickToProceedToCheckoutOnPopupWindow() {

        String parentWindow = driver.getWindowHandle();
        Set<String> childWindows = driver.getWindowHandles();


        Iterator<String> itr = childWindows.iterator();
        while (itr.hasNext()) {
            String child = itr.next();
            if (!parentWindow.equalsIgnoreCase(child)) {
                driver.switchTo().window(child);
                System.out.println("tTitle of window" + driver.switchTo().window(child).getTitle());
                orderPages.clickOnProceed();
            }
        }
        driver.switchTo().window(parentWindow);
    }

    @Then("I click on terms of service checkbox")
    public void iClickOnTermsOfServiceCheckbox() {

        orderPages.selectTermsOfServicesCheckbox();
    }

    @And("I click to proceed to checkout on shipping page")
    public void iClickToProceedToCheckoutOnShippingPage() {
        orderPages.clickToProceedShipping.click();
    }

    @And("I select pay by bank wire")
    public void iSelectPayByBankWire() {

        orderPages.selectPaymentBankWire();
    }

    @And("I confirm the order")
    public void iConfirmTheOrder() {

        orderPages.confirmOrder();
    }

    @And("I navigate to Order history page")
    public void iNavigateToOrderHistoryPage() {

        myAccount.navigateToMyAccountsPage();
    }

    @Then("I verify the order placed is listed in history page")
    public void iVerifyTheOrderPlacedIsListedInHistoryPage() {
        myAccount.clickOnOrdersHistoryDetails();
        System.out.println("Order is successfully placed and order number is  : "+orderHistory.getRefrenceCode());
        Assert.assertTrue(orderPages.getReferenceCode().contains(orderHistory.getRefrenceCode()));
    }

    @And("I navigate to My Personal Information page")
    public void iNavigateToMyPersonalInformationPage() {

        myAccount.navigateToMyAccountsPage();
        myAccount.clickOnPersonalInformation();

    }

    @And("I change the firstname and click save")
    public void iChangeTheFirstnameAndClickSave() {
        myAccount.enterFirstNameandSave(getEnvironmentProperties()
                .getProperty("app.firstname"), getEnvironmentProperties()
                .getProperty("app.password"));
        myAccount.clickSave();

    }

    @Then("verify the firstname changed successfully")
    public void verifyTheFirstnameChangedSuccessfully() {
        Assert.assertTrue(myAccount.verifyAlertMsg());
    }


}
