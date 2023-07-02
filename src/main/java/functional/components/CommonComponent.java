package functional.components;

import functional.pages.CommonPage;
import functional.setup.DriverConfig;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public abstract class CommonComponent<T extends LoadableComponent<T>> extends CommonPage<T> {

    //component can't have URL
    @Override
    protected String getUrl() {
        throw new RuntimeException("Component can't have a URL");
    }

    //Component can't be opened by itself
    public T open() {
        throw new RuntimeException("Component can't be opened by itself");
    }

    public T init() {
        PageFactory.initElements(DriverConfig.getDriver(), this);
        return this.get();
    }
}
