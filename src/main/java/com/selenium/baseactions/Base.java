package com.selenium.baseactions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class Base {
    public static ExtentReports extent;
    public static ExtentTest extentTest;
    public static ExtentTest node;
    public static WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void startReport() {
       WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("TestReport.html");
        extent.attachReporter(spark);
    }

    @BeforeTest
    public void createReportsForTests(ITestContext context) {
        driver.get("https://www.espncricinfo.com/");
        extentTest = extent.createTest(context.getName());
    }

    @BeforeMethod
    public void getAnnotationDetails(Method m, ITestContext context) {
        extentTest.assignAuthor(context.getCurrentXmlTest().getParameter("author"));
        extentTest.assignCategory(m.getAnnotation(Test.class).groups());
        node = extentTest.createNode(m.getAnnotation(Test.class).testName());
    }

    @AfterMethod
    public void getTestStatus(Method m, ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            extentTest.fail("Test Failed");
        } else {
            extentTest.pass(m.getName() + " is passed");
        }
    }

    @AfterSuite
    public void endReport() {
        extent.flush();
        driver.quit();
    }
}


