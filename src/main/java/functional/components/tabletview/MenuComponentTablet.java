package functional.components.tabletview;

import functional.components.CommonComponent;
import functional.components.ResearchAndEducationComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuComponentTablet extends CommonComponent<MenuComponentTablet> {

    @FindBy(css = "[class='fa fa-bars']")
    private WebElement burgerMenu;

    @FindBy(css = "[href='#researchMenu']")
    private WebElement researchMenuItem;
 @FindBy(css = "[class='fa fa-calendar']")
    private WebElement economicCalendarSubItem;

    public ResearchAndEducationComponent clickResearchAndEducationItem() {
        click(burgerMenu);
        scrollToElement(researchMenuItem);
        click(researchMenuItem);
        scrollToElement(economicCalendarSubItem);
        click(economicCalendarSubItem);
        return new ResearchAndEducationComponent().init();
    }
}
