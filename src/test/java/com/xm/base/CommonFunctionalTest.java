package com.xm.base;

import functional.pages.HomePage;
import functional.setup.DriverConfig;
import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static functional.setup.DriverConfig.getDriver;

public abstract class CommonFunctionalTest {

    @BeforeMethod
    @Parameters({"browser", "resolution"})
    public void setup(@Optional String browser,@Optional String resolution) {
        DriverConfig.initDriver(browser, resolution);
        new HomePage().open();
        disableCookiePopup();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverConfig.stopDriver();
    }

    // Here you can add any other cookie that should be putted in page open
    private void disableCookiePopup() {
        getDriver().manage().addCookie(new Cookie("xmck_preferences", "1"));
        getDriver().manage().addCookie(new Cookie("xmck_promotional", "1"));
        getDriver().manage().addCookie(new Cookie("xmck_popupShown", "1"));
        getDriver().manage().addCookie(new Cookie("xmck_analytical", "1"));
        getDriver().manage().addCookie(new Cookie("xmck_functional", "1"));
    }
}
