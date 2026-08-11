import com.microsoft.playwright.*;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.nio.file.Paths;

public class BaseTest {

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
        context = browser.newContext(new Browser.NewContextOptions().setBaseURL("https://demowebshop.tricentis.com"));
        page = context.newPage();
    }

    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult result) {
        if(result.getStatus() == (ITestResult.FAILURE)) {
            String testName = result.getName();
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/" + testName + ".png")));
        }
        context.close();
    }
}
