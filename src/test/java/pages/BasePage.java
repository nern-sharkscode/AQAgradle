package pages;

import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class BasePage {
    protected Page page;
    protected Logger log = LogManager.getLogger(this.getClass());

    public BasePage(Page page) {
        this.page = page;
    }

    protected void click(String locator) {
        log.info("Clicking on element with locator: " + locator);
        page.locator(locator).click();
    }

    protected void fill(String locator, String text) {
        log.info("Filling element with locator: " + locator + " | text: " + text);
        page.locator(locator).fill(text);
    }

    public void navigateTo(String url) {
        page.navigate(url);
    }
}

