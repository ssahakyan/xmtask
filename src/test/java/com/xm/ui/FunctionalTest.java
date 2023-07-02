package com.xm.ui;

import com.xm.base.CommonFunctionalTest;
import lombok.SneakyThrows;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import functional.stepdeinitions.EconomicCalendarStepDefinition;
import functional.stepdeinitions.HomePageStepDefinition;
import functional.stepdeinitions.RiskWarningStepDefinition;

import static org.testng.AssertJUnit.assertEquals;
import static functional.setup.DriverConfig.stopDriver;
import static functional.utils.TestUtils.*;

public class FunctionalTest extends CommonFunctionalTest {

    @Test
    @SneakyThrows
    public void functionalTest () {
        SoftAssert softAssert = new SoftAssert();
        HomePageStepDefinition homePage = new HomePageStepDefinition().open();
        EconomicCalendarStepDefinition economicCalendar = homePage.selectFromResearchAndEducationItem("Economic Calendar");

        economicCalendar.swipeSliderToToday();
        softAssert.assertEquals(economicCalendar.getHeaderLeftTitle(), getTodayDate(), "Today's date is incorrect");
        economicCalendar.swipeSliderToTomorrow();
        softAssert.assertEquals(economicCalendar.getHeaderLeftTitle(), getTomorrowDate(), "Tomorrow's date is incorrect");
        economicCalendar.swipeSliderToThisWeek();
        softAssert.assertEquals(economicCalendar.getHeaderLeftTitle(), getThisWeekDate(), "Date of this week is incorrect");
        economicCalendar.swipeSliderToNextWeek();
        softAssert.assertEquals(economicCalendar.getHeaderLeftTitle(), getNextWeekDate(), "Date of next week is incorrect");
        economicCalendar.swipeSliderToThisMonth();
        softAssert.assertEquals(economicCalendar.getHeaderLeftTitle(), getThisMonthDate(), "Date of this month is incorrect");
        economicCalendar.swipeSliderToNextMonth();
        softAssert.assertEquals(economicCalendar.getHeaderLeftTitle(), getNextMonthDate(), "Date of nex month is incorrect");

        RiskWarningStepDefinition riskWarning = economicCalendar.clickOnRiskWarningLink();
        riskWarning.clickRiskWarningHereLink();
        softAssert.assertTrue(riskWarning.isRiskDisclosuresFinancialInstrumentsUrlCorrect(), "Document url is incorrect");

        softAssert.assertAll();
    }


}
