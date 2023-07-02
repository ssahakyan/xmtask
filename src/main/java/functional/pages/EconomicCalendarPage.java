package functional.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import functional.utils.WaitUtils;

public class EconomicCalendarPage extends CommonPage<EconomicCalendarPage> {

    private static String currentFrame = "default";
    @FindBy(css = "[class='mat-slider-thumb']")
    private WebElement recentNextSlider;
    @FindBy(css = "[class='mat-slider-ticks']")
    private WebElement sliderTicks;
    @FindBy(css = "[class*='tc-economic-calendar-item-header-left-title']")
    private WebElement headerLeftTitle;
    @FindBy(css = "[href='/research/risk_warning']")
    private WebElement riskWarningLink;

    @Override
    protected String getUrl() {
        return "/research/economicCalendar";
    }

    public EconomicCalendarPage swipeSliderToToday() {
        switchToCalendarFrame();
        int coordinate = 60;
        swipeSliderByCoordinate(getCoordinate(1));
        return this;
    }

    public EconomicCalendarPage swipeSliderToTomorrow() {
        switchToCalendarFrame();
        swipeSliderByCoordinate(getCoordinate(2));
        return this;
    }

    public EconomicCalendarPage swipeSliderToThisWeek() {
        switchToCalendarFrame();
        swipeSliderByCoordinate(getCoordinate(3));
        return this;
    }

    public EconomicCalendarPage swipeSliderToNextWeek() {
        switchToCalendarFrame();
        swipeSliderByCoordinate(getCoordinate(4));
        return this;
    }

    public EconomicCalendarPage swipeSliderToThisMonth() {
        switchToCalendarFrame();
        swipeSliderByCoordinate(getCoordinate(5));
        return this;
    }

    public EconomicCalendarPage swipeSliderToNextMonth() {
        switchToCalendarFrame();
        swipeSliderByCoordinate(getCoordinate(6));
        return this;
    }

    public RiskWarningPage clickOnRiskWarningLink() {
        switchToDefaultFrame();
        scrollToElement(riskWarningLink);
        click(riskWarningLink);
        return new RiskWarningPage().init();
    }

    public String getHeaderLeftTitle() {
        switchToCalendarFrame();
        scrollToElement(headerLeftTitle);
        return getTextOrEmpty(headerLeftTitle);
    }

    private boolean swipeSliderByCoordinate(int coordinate) {
        switchToCalendarFrame();
        scrollToElement(headerLeftTitle);
        int locationX = recentNextSlider.getLocation().getX();
        if (locationX == coordinate) {
            return true;
        }
        horizontalMoveElement(recentNextSlider, coordinate - locationX);
        return WaitUtils.waitElementToBeInPosition(recentNextSlider, coordinate);
    }

    private void switchToCalendarFrame() {
        String calendarFrameName = "iFrameResizer0";
        if (!currentFrame.equalsIgnoreCase(calendarFrameName)) {
            switchToIframe("iFrameResizer0");
            currentFrame = "iFrameResizer0";
        }
    }

    private void switchToDefaultFrame() {
        String calendarFrameName = "default";
        if (!currentFrame.equalsIgnoreCase(calendarFrameName)) {
            switchToDefault();
            currentFrame = "default";
        }
    }

    private int getCoordinate(int number) {
        int locationX = sliderTicks.getLocation().getX();
        int range = sliderTicks.getSize().width / 6 * number;
        return locationX + range;
    }
}
