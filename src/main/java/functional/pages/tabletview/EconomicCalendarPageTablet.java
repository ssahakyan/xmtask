package functional.pages.tabletview;

import functional.pages.CommonPage;
import functional.pages.RiskWarningPage;
import functional.utils.WaitUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static functional.utils.WaitUtils.simpleScrollToElement;

public class EconomicCalendarPageTablet extends CommonPage<EconomicCalendarPageTablet> {
    private final static ThreadLocal<String> CURRENT_FRAME = new ThreadLocal<>();

    static {
        CURRENT_FRAME.set("default");
    }

    @FindBy(css = "[class='mat-slider-thumb']")
    private WebElement recentNextSlider;

    @FindBy(css = "[class='mat-slider-ticks']")
    private WebElement sliderTicks;

    @FindBy(css = "[class*='tc-economic-calendar-item-header-left-title']")
    private WebElement headerLeftTitle;

    @FindBy(css = "[aria-label='Show time filter']")
    private WebElement timeFilter;

    @FindBy(css = "[href='/research/risk_warning']")
    private WebElement riskWarningLink;

    @Override
    protected String getUrl() {
        return "/research/economicCalendar";
    }

    public EconomicCalendarPageTablet openTimeFilter() {
        if (!WaitUtils.isExistAndDisplayed(sliderTicks)) {
            switchToCalendarFrame();
            click(timeFilter);
        }
        return this;
    }

    public EconomicCalendarPageTablet swipeSliderToToday() {
        switchToCalendarFrame();
        swipeSliderByCoordinate(getCoordinate(1));
        return this;
    }

    public EconomicCalendarPageTablet swipeSliderToTomorrow() {
        switchToCalendarFrame();
        swipeSliderByCoordinate(getCoordinate(2));
        return this;
    }

    public EconomicCalendarPageTablet swipeSliderToThisWeek() {
        switchToCalendarFrame();
        swipeSliderByCoordinate(getCoordinate(3));
        return this;
    }

    public EconomicCalendarPageTablet swipeSliderToNextWeek() {
        switchToCalendarFrame();
        swipeSliderByCoordinate(getCoordinate(4));
        return this;
    }

    public EconomicCalendarPageTablet swipeSliderToThisMonth() {
        switchToCalendarFrame();
        swipeSliderByCoordinate(getCoordinate(5));
        return this;
    }

    public EconomicCalendarPageTablet swipeSliderToNextMonth() {
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
        return getTextOrEmpty(headerLeftTitle);
    }

    private boolean swipeSliderByCoordinate(int coordinate) {
        int locationX = recentNextSlider.getLocation().getX();
        if (locationX == coordinate) {
            return true;
        }
        simpleScrollToElement(recentNextSlider);
        horizontalMoveElement(recentNextSlider, coordinate - locationX);
        return WaitUtils.waitElementToBeInPosition(recentNextSlider, coordinate);
    }

    private void switchToCalendarFrame() {
        String calendarFrameName = "iFrameResizer0";
        if (!CURRENT_FRAME.get().equalsIgnoreCase(calendarFrameName)) {
            switchToIframe("iFrameResizer0");
            CURRENT_FRAME.set("iFrameResizer0");
        }
    }

    private int getCoordinate(int number) {
        int locationX = sliderTicks.getLocation().getX();
        int range = sliderTicks.getSize().width / 6 * number;
        return locationX + range;
    }

    private void switchToDefaultFrame() {
        String calendarFrameName = "default";
        if (!CURRENT_FRAME.get().equalsIgnoreCase(calendarFrameName)) {
            switchToDefault();
            CURRENT_FRAME.set("default");
        }
    }
}
