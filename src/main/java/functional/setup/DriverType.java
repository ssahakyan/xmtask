package functional.setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public enum DriverType implements IDriverSetup {
    CHROME {
        @Override
        public WebDriver createDriver(MutableCapabilities capabilities) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            //Here you can add chrome specific capabilities
            chromeOptions.merge(capabilities);
            chromeOptions.addArguments("--remote-allow-origins=*");
            return new ChromeDriver(chromeOptions);
        }
    }, SAFARI {
        @Override
        public WebDriver createDriver(MutableCapabilities capabilities) {
            WebDriverManager.safaridriver().setup();
            SafariOptions safariOptions = new SafariOptions();
            //Here you can add safari specific capabilities
            safariOptions.merge(capabilities);
            return new SafariDriver(safariOptions);
        }
    }, FIREFOX {
        @Override
        public WebDriver createDriver(MutableCapabilities capabilities) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            //Here you can add firefox specific capabilities
            firefoxOptions.merge(capabilities);
            return new FirefoxDriver(firefoxOptions);
        }
    }
}
