import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {
    private final Page page;
    private static final String headerRegisterButton = ".ico-register";
    private static final String headerLoginButton = ".ico-login";
    private static final String headerHomeButton = ".header-logo";
    private static final String searchBar = "#small-searchterms";
    private static final String searchButton = ".search-box-button";
    private static final String searchedProductTitle = ".search-results .product-item .product-title a";

    public HomePage(Page page) {
        this.page = page;
    }

    public Locator getSearchedProductTitle(){
        return page.locator(searchedProductTitle);
    }
    public Locator getSearchBar() {
        return page.locator(searchBar);
    }

    public Locator getSearchButton() {
        return page.locator(searchButton);
    }

    public void clickOnSearchButton() {
        page.locator(searchButton).click();
    }

    public void fillSearchBar() {
        page.locator(searchBar).fill("Build your own expensive computer");
    }

    public void clickOnHeaderHomeButton() {
        page.locator(headerHomeButton).click();
    }

    public void clickOnHeaderRegisterButton() {
        page.locator(headerRegisterButton).click();
    }

    public void clickOnHeaderLoginButton() {
        page.locator(headerLoginButton).click();
    }

}
