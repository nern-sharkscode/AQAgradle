import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SearchBarTest extends BaseTest{

    @Test(groups = "positive")
    public void searchProduct(){
        HomePage homePage = new HomePage(page);
        page.navigate("/");
        homePage.fillSearchBar();
        homePage.clickOnSearchButton();
        assertThat(page.locator(".search-results .product-item .product-title a")).hasText("Build your own expensive computer");
    }
}
