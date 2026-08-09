import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {
    private final Page page;
    private final Locator emailInput;
    private final Locator passwordInput;
    private final Locator loginButton;

    public LoginPage(Page page) {
        this.page = page;
        this.emailInput = page.locator("#Email");
        this.passwordInput = page.locator("#Password");
        this.loginButton = page.locator(".login-button");
    }

    public void fillEmailInput(String email) {
        emailInput.fill(email);
    }

    public void fillPasswordInput(String password) {
        passwordInput.fill(password);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }
}
