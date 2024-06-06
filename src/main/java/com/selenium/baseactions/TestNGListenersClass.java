package com.selenium.baseactions;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
public class TestNGListenersClass implements IRetryAnalyzer {
    private int executionCount = 0;
    private static int maxTryCount = 1;
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if (executionCount < maxTryCount) {
                executionCount++;
                iTestResult.setStatus(ITestResult.FAILURE);
                return true;
            } else {
                iTestResult.setStatus(ITestResult.FAILURE);
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);
        }
        return false;
    }
}
