package functional.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import functional.setup.ConfigurationProperties;
import functional.utils.WaitUtils;

import java.util.List;

import static functional.setup.DriverConfig.getDriver;

public abstract class CommonPage<T extends LoadableComponent<T>> extends LoadableComponent<T> {

    protected abstract String getUrl();

    public T open() {
        load();
        return init();
    }

    public T init() {
        PageFactory.initElements(getDriver(), this);
        return this.get();
    }

    @Override
    protected void load() {
        getDriver().get(ConfigurationProperties.BASE_URL + getUrl());
    }

    @Override
    protected void isLoaded() throws Error {
        WaitUtils.waitPageToBeLoaded();
    }


    protected void click(WebElement element) {
        WaitUtils.waitElementToBeClickable(element).click();
    }
    
    public void horizontalMoveElement(WebElement element, int targetPosition) {
        WaitUtils.waitElementToBeVisible(element);
        Actions actions = new Actions(getDriver());
        actions.dragAndDropBy(element, targetPosition, 0).perform();
    }

    public void clickByText(List<WebElement> elements, String text) {
        WebElement element = WaitUtils.waitElementToBeVisible(elements, text);
        scrollToElement(element);
        element.click();
    }

    public void type(WebElement element, String text) {
        WaitUtils.waitElementToBeVisible(element).sendKeys(text);
    }

    protected String getText(WebElement element) {
        return WaitUtils.waitElementToBeVisible(element).getText();
    }

    protected String getTextOrEmpty(WebElement element) {
        try {
        return WaitUtils.waitElementToBeVisible(element).getText();
        } catch (Exception ignore) {
            return "";
        }
    }

    protected void switchToIframe(String element) {
        WaitUtils.waitAndSwitchToElement(element);
    }

    protected void switchToDefault() {
        getDriver().switchTo().defaultContent();
    }

    public static Boolean scrollToElement(WebElement element) {
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));"
                + "return true;";
        try {
            return (Boolean) WaitUtils.executeScript(scrollElementIntoMiddle, element);
        } catch (Exception ignore) {
            return false;
        }
    }
}
