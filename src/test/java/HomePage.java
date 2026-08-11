import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {
    private final Page page;
    private final Locator headerRegisterButton;
    private final Locator headerLoginButton;
    private final Locator headerHomeButton;
    private final Locator searchBar;
    private final Locator searchButton;
    private final Locator slider;
    private final Locator nivoControlNav;
    private final Locator productGrid;

    public HomePage(Page page) {
        this.page = page;
        this.headerRegisterButton = page.locator(".ico-register");
        this.headerLoginButton = page.locator(".ico-login");
        this.headerHomeButton = page.locator(".header-logo");
        this.searchBar = page.locator("#small-searchterms");
        this.searchButton = page.locator(".search-box-button");
        this.slider = page.locator("#nivo-slider");
        this.nivoControlNav = page.locator(".nivo-controlNav");
        this.productGrid = page.locator(".home-page-product-grid");
    }

    public Locator getSearchBar(){
        return searchBar;
    }

    public Locator getSearchButton(){
        return searchButton;
    }
     public void clickOnSearchButton(){
        searchButton.click();
     }

    public void fillSearchBar(){
        searchBar.fill("Build your own expensive computer");
    }

    public void clickOnHeaderHomeButton() {
        headerHomeButton.click();
    }

    public void clickOnHeaderRegisterButton() {
        headerRegisterButton.click();
    }

    public void clickOnHeaderLoginButton() {
        headerLoginButton.click();
    }

}
