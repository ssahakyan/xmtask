package functional.stepdeinitions;

import functional.pages.HomePage;
import functional.pages.tabletview.HomePageTablet;
import functional.setup.DriverConfig;

public class HomePageStepDefinition extends CommonStepDefinition<HomePageStepDefinition> {

    private HomePage homePage;
    private HomePageTablet homePageTablet;

    @Override
    public HomePageStepDefinition init() {
        if (DriverConfig.IS_TABLET_VIEW) {
            homePageTablet = new HomePageTablet().init();
        } else {
            homePage = new HomePage().init();
        }
        return this;
    }

    @Override
    public HomePageStepDefinition open() {
        if (DriverConfig.IS_TABLET_VIEW) {
            homePageTablet = new HomePageTablet().open();
        } else {
            homePage = new HomePage().open();
        }
        return this;
    }

    public EconomicCalendarStepDefinition selectFromResearchAndEducationItem(String text) {
        if (DriverConfig.IS_TABLET_VIEW) {
            homePageTablet.getMenuComponentTablet().clickResearchAndEducationItem();
        } else {
            homePage.getMenuComponent()
                    .clickResearchAndEducationItem()
                    .clickMenuResearchItemByText(text);
        }
        return new EconomicCalendarStepDefinition().init();
    }
}
