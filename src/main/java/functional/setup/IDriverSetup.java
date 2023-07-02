package functional.setup;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface IDriverSetup {
    WebDriver createDriver(MutableCapabilities capabilities);
}
