package functional.pages;

import functional.components.MenuComponent;

public class HomePage extends CommonPage<HomePage> {

    @Override
    protected String getUrl() {
        return "/";
    }

    public MenuComponent getMenuComponent() {
        return new MenuComponent().init();
    }
}
