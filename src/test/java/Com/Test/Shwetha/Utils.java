package Com.Test.Shwetha;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.interactions.Actions;


import static java.time.temporal.ChronoUnit.MILLIS;
import static java.time.temporal.ChronoUnit.SECONDS;

public class Utils {


    public Properties getPropertiesFromFile(String filePath) {
        Properties props;
        props = new Properties();

        try {
            props.load(new FileInputStream(filePath));
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
        return props;
    }


    public static FluentWait<WebDriver> getWait(WebDriver driver) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .ignoring(StaleElementReferenceException.class).ignoring(NoSuchWindowException.class)
                .ignoring(NoSuchElementException.class).ignoring(ElementClickInterceptedException.class)
                .pollingEvery(Duration.of(100, MILLIS))
                .withTimeout(Duration.of(10, SECONDS))
                .withMessage("Not found!");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return wait;
    }

    public static WebElement findElementContainingTextUsingXpath(WebDriver driver, String locator) {
        return driver.findElement(By.xpath("//*[contains(text(),'" + locator + "')]"));
    }

    public static void mouseHoverOnElement(WebDriver driver, WebElement ele) {
        Actions builder = new Actions(driver);
        builder.moveToElement(ele).build().perform();
    }

    public static void scrolltoElementAndClick(WebDriver driver, WebElement ele) {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ele);
        ele.click();
    }

}
