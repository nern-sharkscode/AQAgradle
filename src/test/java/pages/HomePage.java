package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import jdk.jfr.Registered;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomePage extends BasePage {
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

    @Step("clickOnLogoutButton")
    public void clickOnLogoutButton() {
        page.locator(logOutButton).click();
    }

    @Step("clickOnSearchButton")
    public void clickOnSearchButton() {
        page.locator(searchButton).click();
    }

    @Step("fillSearchBar")
    public void fillSearchBar(String searchText) {
        page.locator(searchBar).fill(searchText);
    }

    @Step("clickOnHeaderHomeButton")
    public void clickOnHeaderHomeButton() {
        page.locator(headerHomeButton).click();
    }

    @Step("clickOnHeaderRegisterButton")
    public void clickOnHeaderRegisterButton() {
        page.locator(headerRegisterButton).click();
    }

    @Step("clickOnHeaderLoginButton")
    public void clickOnHeaderLoginButton() {
        page.locator(headerLoginButton).click();
    }

    @Step("verifyLogoutButtonIsHidden")
    public void verifyLogoutButtonIsHidden() {
        assertThat(page.locator(logOutButton)).isHidden();
    }

    @Step("verifySearchedProductTitle")
    public void verifySearchedProductTitle(String productTitle) {
        assertThat(page.locator(searchedProductTitle)).containsText(productTitle);
    }

}
