package functional.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuComponent extends CommonComponent<MenuComponent> {

    @FindBy(css = "[class='main_nav_research']")
    private WebElement researchAndEducationItem;

    public ResearchAndEducationComponent clickResearchAndEducationItem() {
        click(researchAndEducationItem);
        return new ResearchAndEducationComponent().init();
    }

}
