package Com.Test.Shwetha.pages;

import Com.Test.Shwetha.SeleneseBase;
import Com.Test.Shwetha.Utils;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class OrderPages extends SeleneseBase {

    SeleneseBase testContext;

    public OrderPages(SeleneseBase testContext, WebDriver driver) {
        this.testContext = testContext;
        this.driver = driver;
    }

    @Setter
    @Getter
    public String referenceCode;


    @FindBy(how = How.XPATH, using = "//*[contains(@id,'uniform-layered_id_attribute_group')]//input")
    List<WebElement> tShirtSizeList;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Add to cart')]")
    WebElement addToCartTab;

    @FindBy(how = How.ID, using = "uniform-cgv")
    WebElement termsCheckBox;

    @FindBy(how = How.CSS, using = "a[title='Pay by bank wire']")
    WebElement payByBankWire;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'I confirm my order')]")
    WebElement confirmOrder;

    @FindBy(how = How.XPATH, using = "//div[@class='box']")
    WebElement orderReferenceCode;


    @FindBy(how = How.CLASS_NAME, using = "product_img_link")
    WebElement tShirtImage;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Proceed to checkout')]")
    WebElement clickToProceed;

    @FindBy(how = How.CLASS_NAME, using = "standard-checkout")
    public WebElement clickToProceedSummary;

    @FindBy(how = How.CSS, using = "button[name='processAddress']")
    public WebElement clickToProceedAddress;


    @FindBy(how = How.CSS, using = "button[name='processCarrier']")
    public  WebElement clickToProceedShipping;


    public void selectTshirtSizeSmall() {
        tShirtSizeList.get(0).click();
    }

    public void clickOnAddToCart() {
        tShirtImage.click();
        // Utils.mouseHoverOnElement(driver,tShirtImage);
        driver.switchTo().frame(0);
        Utils.getWait(driver).until(ExpectedConditions.elementToBeClickable(addToCartTab));
        addToCartTab.click();
        driver.switchTo().defaultContent();

    }

    public void clickOnProceed() {
        Utils.getWait(driver).until(ExpectedConditions.elementToBeClickable(clickToProceed));
        clickToProceed.click();

    }

    public void selectTermsOfServicesCheckbox() {
        Utils.getWait(driver).until(ExpectedConditions.visibilityOf(termsCheckBox));
        termsCheckBox.click();
    }

    public void selectPaymentBankWire() {
        Utils.getWait(driver).until(ExpectedConditions.elementToBeClickable(payByBankWire));
        payByBankWire.click();
    }

    public void confirmOrder() {
        Utils.getWait(driver).until(ExpectedConditions.elementToBeClickable(confirmOrder));
        confirmOrder.click();
        getOrderReferenceCode();
    }


    public String getOrderReferenceCode() {
        referenceCode = orderReferenceCode.getText();
        return referenceCode.toString();
    }


}



