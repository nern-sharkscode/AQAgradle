package tests;

import com.microsoft.playwright.*;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Properties;

public class BaseTest {

    // Shared between all tests in this class.
    Playwright playwright;
    Browser browser;

    // New instance for each test method.
    BrowserContext context;
    Page page;
    Properties config = new Properties();

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
        try (InputStream input = new FileInputStream("src/test/resources/config.properties")) {
            config.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        context = browser.newContext(new Browser.NewContextOptions().setBaseURL(config.getProperty("baseUrl")));
        page = context.newPage();
        page.navigate("/");
    }

    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult result) {
        if (result.getStatus() == (ITestResult.FAILURE)) {
            String testName = result.getName();
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/" + testName + ".png")));
        }
        context.close();
    }
}
