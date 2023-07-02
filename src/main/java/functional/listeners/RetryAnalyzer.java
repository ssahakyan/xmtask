package functional.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import static functional.setup.ConfigurationProperties.RETRY_COUNT;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int counter = 0;

    @Override
    public boolean retry(ITestResult result) {
        if (counter < RETRY_COUNT) {
            counter++;
            return true;
        }
        return false;
    }
}