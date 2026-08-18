package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPage extends BasePage {
    private static final String emailInput = "#Email";
    private static final String passwordInput = "#Password";
    private static final String loginButton = ".login-button";
    private static final String headerUserEmail = ".header-links .account";
    private static final String validationSummaryErrors = ".validation-summary-errors";

    public LoginPage(Page page) {
        super(page);
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

    public void verifyValidationError(String expectedText) {
        assertThat(page.locator(validationSummaryErrors)).containsText(expectedText);
    }

    public void verifySuccessLogin(String expectedLogin) {
        assertThat(page.locator(headerUserEmail)).containsText(expectedLogin);
    }
}
