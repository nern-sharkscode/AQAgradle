import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomeLoginPage {
    private final Page page;
    private final Locator logOutButton;

    public Locator getLogOutButton(){
        return logOutButton;
    }
    public HomeLoginPage(Page page){
        this.page = page;
        this.logOutButton = page.locator(".ico-logout");
    }

    public void clickOnLogoutButton(){
        logOutButton.click();
    }
}
