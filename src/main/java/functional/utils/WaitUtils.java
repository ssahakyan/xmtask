package functional.utils;

import functional.setup.DriverConfig;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static functional.setup.ConfigurationProperties.WAIT_TIMEOUT;

public class WaitUtils {

    public static boolean waitPageToBeLoaded() {
        WebDriverWait wait = new WebDriverWait(DriverConfig.getDriver(), Duration.ofSeconds(WAIT_TIMEOUT));
        return wait.until((ExpectedCondition<Boolean>) webDriver -> {
            try {
                JavascriptExecutor js = (JavascriptExecutor) DriverConfig.getDriver();
                return js.executeScript("return document.readyState").toString().equals("complete");
            } catch (Exception e) {
                return false;
            }
        });
    }

    public static WebElement waitElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverConfig.getDriver(), Duration.ofSeconds(WAIT_TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static Boolean waitElementToBeInPosition(WebElement element, int coordinateX) {
        WebDriverWait wait = new WebDriverWait(DriverConfig.getDriver(), Duration.ofSeconds(WAIT_TIMEOUT));
        return wait.until((ExpectedCondition<Boolean>) webDriver -> {
            try {
                return element.getLocation().getX() < (coordinateX * 115 / 100) && element.getLocation().getX() > (coordinateX * 85 / 100);
            } catch (Exception e) {
                return false;
            }
        });
    }

    public static WebElement waitElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverConfig.getDriver(), Duration.ofSeconds(WAIT_TIMEOUT));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static Object executeScript(String script, WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) DriverConfig.getDriver();
        return executor.executeScript(script, element);
    }

    public static WebElement waitElementToBeVisible(List<WebElement> elements, String text) {
        WebDriverWait wait = new WebDriverWait(DriverConfig.getDriver(), Duration.ofSeconds(WAIT_TIMEOUT));
        return wait.until((ExpectedCondition<WebElement>) webDriver -> {
            try {
                return elements.stream().filter(element -> element.getText().equalsIgnoreCase(text)).findFirst().orElse(null);
            } catch (Exception e) {
                return null;
            }
        });
    }

    public static boolean waitAndSwitchToElement(String idOrName) {
        WebDriverWait wait = new WebDriverWait(DriverConfig.getDriver(), Duration.ofSeconds(WAIT_TIMEOUT));
        return wait.until((ExpectedCondition<Boolean>) webDriver -> {
            try {
                DriverConfig.getDriver().switchTo().frame(idOrName);
                return true;
            } catch (Exception e) {
                return false;
            }
        });
    }

    public static boolean isExistAndDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public static void waitUrlToNotBeBlank() {
        WebDriverWait wait = new WebDriverWait(DriverConfig.getDriver(), Duration.ofSeconds(WAIT_TIMEOUT));
        wait.until((ExpectedCondition<Boolean>) webDriver -> !DriverConfig
                .getDriver()
                .getCurrentUrl()
                .equalsIgnoreCase("about:blank"));
    }

    public static void simpleScrollToElement(WebElement element) {
        WaitUtils.executeScript("arguments[0].scrollIntoView();", element);
    }
}
