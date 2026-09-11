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
        click(logOutButton);
    }

    @Step("clickOnSearchButton")
    public void clickOnSearchButton() {
        click(searchButton);
    }

    @Step("fillSearchBar")
    public void fillSearchBar(String searchText) {
        fill(searchBar, searchText);
    }

    @Step("clickOnHeaderHomeButton")
    public void clickOnHeaderHomeButton() {
        click(headerHomeButton);
    }

    @Step("clickOnHeaderRegisterButton")
    public void clickOnHeaderRegisterButton() {
        click(headerRegisterButton);
    }

    @Step("clickOnHeaderLoginButton")
    public void clickOnHeaderLoginButton() {
        click(headerLoginButton);
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
