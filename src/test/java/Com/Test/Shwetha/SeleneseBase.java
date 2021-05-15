package Com.Test.Shwetha;

import Com.Test.Shwetha.pages.LoginPage;
import Com.Test.Shwetha.pages.MyAccount;
import Com.Test.Shwetha.pages.OrderHistory;
import Com.Test.Shwetha.pages.OrderPages;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class SeleneseBase {

    Utils util = new Utils();

    @Getter
    @Setter
    public LoginPage loginPage;

    @Getter
    @Setter
    public MyAccount myAccount;

    @Getter
    @Setter
    public OrderPages orderPages;

    @Getter
    @Setter
    public OrderHistory orderHistory;

    @Getter
    @Setter
    public WebDriver driver;


    public Properties environmentProperties;
    public static String environmentPropertiesFile = System.getProperty("user.dir") + File.separator + "environment.properties";


    public Properties getEnvironmentProperties() {
        environmentProperties = util.getPropertiesFromFile(environmentPropertiesFile);
        return environmentProperties;
    }

    public void initializePageObjects(WebDriver driver) {
        loginPage = new LoginPage(this, driver);
        PageFactory.initElements(driver, loginPage);
        myAccount = new MyAccount(this, driver);
        PageFactory.initElements(driver, myAccount);
        orderHistory = new OrderHistory(this, driver);
        PageFactory.initElements(driver, orderHistory);
        orderPages = new OrderPages(this, driver);
        PageFactory.initElements(driver, orderPages);

    }

    public WebDriver createWebdriver() {
        WebDriver driver = null;
        Map<String, Object> prefs = new HashMap<String, Object>();
        String Browsertype = getEnvironmentProperties().getProperty("browser.type");
        if (Browsertype.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }

        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
        return driver;
    }


}
