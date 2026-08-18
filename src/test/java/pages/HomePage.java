package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage extends BasePage{
    private static final String headerRegisterButton = ".ico-register";
    private static final String headerLoginButton = ".ico-login";
    private static final String headerHomeButton = ".header-logo";
    private static final String searchBar = "#small-searchterms";
    private static final String searchButton = ".search-box-button";
    private static final String searchedProductTitle = ".search-results .product-item .product-title a";
    private static final String logOutButton = ".ico-logout";

    public HomePage(Page page) {
        super(page);
    }

    public Locator getSearchedProductTitle() {
        return page.locator(searchedProductTitle);
    }

    public Locator getSearchBar() {
        return page.locator(searchBar);
    }

    public Locator getSearchButton() {
        return page.locator(searchButton);
    }

    public Locator getLogOutButton(){
        return page.locator(logOutButton);
    }

    public void clickOnLogoutButton() {
        page.locator(logOutButton).click();
    }

    public void clickOnSearchButton() {
        page.locator(searchButton).click();
    }

    public void fillSearchBar(String searchText) {
        page.locator(searchBar).fill(searchText);
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
