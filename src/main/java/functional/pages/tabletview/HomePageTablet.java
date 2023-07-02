package functional.pages.tabletview;

import functional.components.tabletview.MenuComponentTablet;
import functional.pages.CommonPage;

public class HomePageTablet extends CommonPage<HomePageTablet> {

    @Override
    protected String getUrl() {
        return "/";
    }

    public MenuComponentTablet getMenuComponentTablet() {
        return new MenuComponentTablet().init();
    }
}
