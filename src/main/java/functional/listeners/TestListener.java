package functional.listeners;

import lombok.extern.log4j.Log4j2;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Log4j2
public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        log.info("<<<<<<< Test start >>>>>>>");
        log.info(iTestResult.getMethod().getQualifiedName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info("<<<<<<< Test passed >>>>>>>");
        log.info(iTestResult.getMethod().getQualifiedName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.info("<<<<<<< Test Failed >>>>>>>");
        log.info(iTestResult.getMethod().getQualifiedName());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log.info("<<<<<<< Test skipped >>>>>>>");
        log.info(iTestResult.getMethod().getQualifiedName());
    }

    @Override
    public void onStart(ITestContext context) {
        log.info("<<<<<<< Suit start >>>>>>>");
        log.info(context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("<<<<<<< Suit finished >>>>>>>");
        log.info(context.getName());
    }
}
