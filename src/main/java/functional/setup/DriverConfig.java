package functional.setup;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static functional.setup.ConfigurationProperties.BROWSER;
import static functional.setup.ConfigurationProperties.RESOLUTION;

public class DriverConfig {

    private static final ThreadLocal<WebDriver> DRIVER_THREAD = new ThreadLocal<>();
    public static boolean IS_TABLET_VIEW;

    private DriverConfig() {
    }

    public static void initDriver(String browser, String resolution) {
        if (browser != null)
            DRIVER_THREAD.set(DriverType
                    .valueOf(browser.toUpperCase())
                    .createDriver(getCommonDesiredCapabilities()));
        else
            DRIVER_THREAD.set(DriverType
                    .valueOf(BROWSER)
                    .createDriver(getCommonDesiredCapabilities()));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        if (resolution != null)
            setResolution(resolution);
        else
            setResolution(RESOLUTION);
    }

    private static void setResolution(String resolution) {
        if (resolution == null || resolution.equalsIgnoreCase("MAXIMUM")) {
            getDriver().manage().window().maximize();
            IS_TABLET_VIEW = false;
        } else {
            String[] dimensions = resolution.toLowerCase().split("x");
            getDriver().manage().window().setSize(
                    new Dimension(Integer.parseInt(dimensions[0].trim()), Integer.parseInt(dimensions[1].trim())));
            //xm.com changes to tablet view under the 991 px height
            if (Integer.parseInt(dimensions[0]) > 991) IS_TABLET_VIEW = false;
            else IS_TABLET_VIEW = true;

        }
    }

    public static WebDriver getDriver() {
        return DRIVER_THREAD.get();
    }

    public static void stopDriver() {
        if (DRIVER_THREAD.get() != null) {
            getDriver().quit();
            DRIVER_THREAD.remove();
        }
    }

    //In case you need to pass capabilities for all browsers
    private static MutableCapabilities getCommonDesiredCapabilities() {
        MutableCapabilities capabilities = new MutableCapabilities();
        // write your capability here
        return capabilities;
    }
}
