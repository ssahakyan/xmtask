package functional.stepdeinitions;

import functional.pages.EconomicCalendarPage;
import functional.pages.tabletview.EconomicCalendarPageTablet;
import functional.setup.DriverConfig;

public class EconomicCalendarStepDefinition extends CommonStepDefinition<EconomicCalendarStepDefinition> {

    private EconomicCalendarPage economicCalendarPage;
    private EconomicCalendarPageTablet economicCalendarPageTablet;

    public EconomicCalendarStepDefinition init() {
        if (DriverConfig.IS_TABLET_VIEW) {
            economicCalendarPageTablet = new EconomicCalendarPageTablet().init();
        } else {
            economicCalendarPage = new EconomicCalendarPage().init();
        }
        return this;
    }

    @Override
    public EconomicCalendarStepDefinition open() {
        if (DriverConfig.IS_TABLET_VIEW) {
            economicCalendarPageTablet = new EconomicCalendarPageTablet().open();
        } else {
            economicCalendarPage = new EconomicCalendarPage().open();
        }
        return this;
    }

    public EconomicCalendarStepDefinition swipeSliderToToday() {
        if (DriverConfig.IS_TABLET_VIEW) {
            economicCalendarPageTablet.openTimeFilter().swipeSliderToToday();
        } else {
            economicCalendarPage.swipeSliderToToday();
        }
        return this;
    }

    public EconomicCalendarStepDefinition swipeSliderToTomorrow() {
        if (DriverConfig.IS_TABLET_VIEW) {
            economicCalendarPageTablet.swipeSliderToTomorrow();
        } else {
            economicCalendarPage.swipeSliderToTomorrow();
        }
        return this;
    }

    public EconomicCalendarStepDefinition swipeSliderToThisWeek() {
        if (DriverConfig.IS_TABLET_VIEW) {
            economicCalendarPageTablet.swipeSliderToThisWeek();
        } else {
            economicCalendarPage.swipeSliderToThisWeek();
        }
        return this;
    }

    public EconomicCalendarStepDefinition swipeSliderToNextWeek() {
        if (DriverConfig.IS_TABLET_VIEW) {
            economicCalendarPageTablet.swipeSliderToNextWeek();
        } else {
            economicCalendarPage.swipeSliderToNextWeek();
        }
        return this;
    }

    public EconomicCalendarStepDefinition swipeSliderToThisMonth() {
        if (DriverConfig.IS_TABLET_VIEW) {
            economicCalendarPageTablet.swipeSliderToThisMonth();
        } else {
            economicCalendarPage.swipeSliderToThisMonth();
        }
        return this;
    }

    public EconomicCalendarStepDefinition swipeSliderToNextMonth() {
        if (DriverConfig.IS_TABLET_VIEW) {
            economicCalendarPageTablet.swipeSliderToNextMonth();
        } else {
            economicCalendarPage.swipeSliderToNextMonth();
        }
        return this;
    }

    public RiskWarningStepDefinition clickOnRiskWarningLink() {
        if (DriverConfig.IS_TABLET_VIEW) {
            economicCalendarPageTablet.clickOnRiskWarningLink();
        } else {
            economicCalendarPage.clickOnRiskWarningLink();
        }
        return new RiskWarningStepDefinition().init();
    }

    public String getHeaderLeftTitle() {
        if (DriverConfig.IS_TABLET_VIEW) {
            return economicCalendarPageTablet.getHeaderLeftTitle();
        } else {
            return economicCalendarPage.getHeaderLeftTitle();
        }
    }
}
