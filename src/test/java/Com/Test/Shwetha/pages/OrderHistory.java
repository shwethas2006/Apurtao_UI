package Com.Test.Shwetha.pages;

import Com.Test.Shwetha.SeleneseBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class OrderHistory extends SeleneseBase {

    SeleneseBase testContext;

    public OrderHistory(SeleneseBase testContext, WebDriver driver) {
        this.testContext = testContext;
        this.driver = driver;
    }

    @FindBy(how = How.CLASS_NAME, using = "color-myaccount")
    List<WebElement> ordersRefreceCode;



    public  String getRefrenceCode()
    {

       return ordersRefreceCode.get(0).getText();
    }


}
