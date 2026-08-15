package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {
    private static final String emailInput = "#Email";
    private static final String passwordInput = "#Password";
    private static final String loginButton = ".login-button";
    private static final String headerUserEmail = ".header-links .account";
    private static final String validationSummaryErrors = ".validation-summary-errors";

    public LoginPage(Page page) {
        super(page);
    }

    public Locator getHeaderUserEmail() {
        return page.locator(headerUserEmail);
    }

    public Locator getValidationSummaryErrors() {
        return page.locator(validationSummaryErrors);
    }

    public void fillEmailInput(String email) {
        page.locator(emailInput).fill(email);
    }

    public void fillPasswordInput(String password) {
        page.locator(passwordInput).fill(password);
    }

    public void clickOnLoginButton() {
        page.locator(loginButton).click();
    }

    public void loginAs(String email, String password) {
        fillEmailInput(email);
        fillPasswordInput(password);
        clickOnLoginButton();
    }
}
