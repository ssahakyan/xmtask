package functional.setup;

import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Log4j2
public class ConfigurationProperties {
    private static final Properties configuration;
    public static final String BASE_URL;
    public static final String BROWSER;
    public static final int WAIT_TIMEOUT;
    public static final int RETRY_COUNT;
    public static final String RESOLUTION;
    public static final String API_URL;

    static {
        configuration = new Properties();
        try  {
            InputStream file = Thread.currentThread().getContextClassLoader().getResourceAsStream("configuration.properties");
            configuration.load(file);
            if (file != null) file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BASE_URL = getProperty("base_url");
        API_URL = getProperty("api_url");
        BROWSER = getProperty("browser");
        WAIT_TIMEOUT = Integer.parseInt(getProperty("element_wait_timeout"));
        RETRY_COUNT = Integer.parseInt(getProperty("retry_count"));
        RESOLUTION = getProperty("resolution");

        log.info("Initializing project with configuration: ");
        log.info(String.format("Base URL: %s", BASE_URL));
        log.info(String.format("Browser: %s", BROWSER));
        log.info(String.format("Screen resolution: %s", RESOLUTION));
        log.info(String.format("Retry count in case of fail: %s", RETRY_COUNT));
        log.info(String.format("API url: %s", API_URL));
    }

    private ConfigurationProperties() {
    }

    public static String getProperty(String key) {
        if (System.getProperty(key) == null || System.getProperty(key).isEmpty()) {
            return configuration.getProperty(key);
        } else {
            return System.getProperty(key);
        }
    }
}