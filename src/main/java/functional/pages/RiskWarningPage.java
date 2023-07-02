package functional.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RiskWarningPage extends CommonPage<RiskWarningPage>{

    //TODO This is not the best way to locate element on the page, as it will make the test unstable. Unique attribute needs to be requested  from the dev team.
    @FindBy(css = "#research-app [href*='https://cloud.xm-cdn.com/static/pdf/System-PDFs/XMGlobal-Risk-Disclosures-for-Financial-Instruments.pdf']")
    private WebElement riskWarningHereLink;

    @Override
    protected String getUrl() {
        return "/research/risk_warning";
    }

    public void clickRiskWarningHereLink() {
        scrollToElement(riskWarningHereLink);
        click(riskWarningHereLink);
    }
}