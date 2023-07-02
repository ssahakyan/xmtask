package functional.components;

import functional.pages.EconomicCalendarPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResearchAndEducationComponent extends CommonComponent<ResearchAndEducationComponent>{

    @FindBy(css = "[class='main_nav_research selected'] [class='box hidden-xs hidden-sm']")
    private WebElement title;

    @FindBy(css = "[class='main_nav_research selected'] [class='menu-research']")
    private List<WebElement> menuResearchItems;

    public EconomicCalendarPage clickMenuResearchItemByText(String text) {
        clickByText(menuResearchItems, text);
        return new EconomicCalendarPage().init();
    }
}
