package Com.Test.Shwetha;


import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.NoSuchSessionException;

import java.util.concurrent.TimeUnit;

public class Hooks extends SeleneseBase {

    SeleneseBase testContext;

    public Hooks(SeleneseBase testContext) {

        this.testContext = testContext;
    }

    @Given("I open the browser")
    public void iOpenABrowserWindow() {
        driver = createWebdriver();
        testContext.setDriver(driver);
    }

    @And("Open the AutomationPractice application URL")
    public void openTheAutomationapplicationURL() {
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.get(getEnvironmentProperties().getProperty("app.url"));
    }


    /**
     * Tear down method to be triggered after a particular test class is run, it does the following:
     * -- closes the browser window
     */
    @After
    public void cleanUpSession() {
        driver = testContext.getDriver();


        if (driver != null) {
            driver.manage().deleteAllCookies();

            try {
                for (String handle : driver.getWindowHandles()) {
                    driver.switchTo().window(handle);
                    driver.close();
                }

                if (driver != null) driver.quit();
            } catch (NoSuchSessionException e) {
            }
        }

    }



}

