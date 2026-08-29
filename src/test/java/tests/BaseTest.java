package tests;

import com.microsoft.playwright.*;
import io.qameta.allure.testng.AllureTestNg;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.ConfigReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Properties;

@Listeners({AllureTestNg.class})
public class BaseTest {
    protected static final Logger logger = LogManager.getLogger(BaseTest.class);
    // Shared between all tests in this class.
    Playwright playwright;
    Browser browser;

    // New instance for each test method.
    BrowserContext context;
    Page page;

    @BeforeClass
    void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @AfterClass
    void closeBrowser() {
        playwright.close();
    }

    @BeforeMethod
    void createContextAndPage() {
        context = browser.newContext(new Browser.NewContextOptions().setBaseURL(ConfigReader.getBaseUrl()));
        page = context.newPage();
        page.navigate("/");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        if (result.getStatus() == ITestResult.SUCCESS) {
            logger.info(testName + " is passed successfully :)");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/" + testName + ".png")));
            logger.error(testName + " is passed unsuccessfully :(");
        }
        context.close();
    }
}
