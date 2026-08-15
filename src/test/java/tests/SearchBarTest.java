package tests;

import org.testng.annotations.Test;
import pages.HomePage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SearchBarTest extends BaseTest {

    @Test(groups = "positive")
    public void searchProduct(){
        String productName = "Build your own expensive computer";
        HomePage homePage = new HomePage(page);
        homePage.fillSearchBar();
        homePage.clickOnSearchButton();
        assertThat(homePage.getSearchedProductTitle()).hasText(productName);
    }
}
