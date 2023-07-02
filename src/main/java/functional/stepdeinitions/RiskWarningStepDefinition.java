package functional.stepdeinitions;

import functional.pages.RiskWarningPage;
import functional.pages.tabletview.RiskWarningPageTablet;
import functional.setup.DriverConfig;
import functional.utils.WaitUtils;

public class RiskWarningStepDefinition extends CommonStepDefinition<RiskWarningStepDefinition> {
    private String riskDisclosuresFinancialInstrumentsUrl =
            "https://cloud.xm-cdn.com/static/pdf/System-PDFs/XMGlobal-Risk-Disclosures-for-Financial-Instruments.pdf";

    private RiskWarningPage riskWarningPage;
    private RiskWarningPageTablet riskWarningPageTablet;

    @Override
    public RiskWarningStepDefinition init() {
        if (DriverConfig.IS_TABLET_VIEW) {
            riskWarningPageTablet = new RiskWarningPageTablet().init();
        } else {
            riskWarningPage = new RiskWarningPage().init();
        }
        return this;
    }

    @Override
    public RiskWarningStepDefinition open() {
        if (DriverConfig.IS_TABLET_VIEW) {
            riskWarningPageTablet = new RiskWarningPageTablet().open();
        } else {
            riskWarningPage = new RiskWarningPage().open();
        }
        return this;
    }

    public void clickRiskWarningHereLink() {
        if (DriverConfig.IS_TABLET_VIEW) {
            riskWarningPageTablet.clickRiskWarningHereLink();
        } else {
            riskWarningPage.clickRiskWarningHereLink();
        }
    }

    public boolean isRiskDisclosuresFinancialInstrumentsUrlCorrect() {
        String currentWindow = DriverConfig.getDriver().getWindowHandle();
        String nextWindow = DriverConfig.getDriver().getWindowHandles().stream().filter(tab -> !tab.equalsIgnoreCase(currentWindow)).findFirst().get();
        DriverConfig.getDriver().switchTo().window(nextWindow);
        WaitUtils.waitUrlToNotBeBlank();
        return DriverConfig.getDriver().getCurrentUrl().contains(riskDisclosuresFinancialInstrumentsUrl);
    }
}
