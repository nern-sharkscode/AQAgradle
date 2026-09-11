package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

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

    @Step("fillEmailInput")
    public LoginPage fillEmailInput(String email) {
        fill(emailInput,email);
        return this;
    }

    @Step("fillPasswordInput")
    public LoginPage fillPasswordInput(String password) {
        fill(passwordInput,password);return this;
    }

    @Step("clickOnLoginButton")
    public LoginPage clickOnLoginButton() {
        click(loginButton);
        return this;
    }

    @Step("Check if field validation contain text \"Login was unsuccessful.\"")
    public LoginPage verifyValidationError(String expectedText) {
        assertThat(page.locator(validationSummaryErrors)).containsText(expectedText);
        return this;
    }

    @Step("Check if user email is visible on page header")
    public LoginPage verifySuccessLogin(String expectedLogin) {
        assertThat(page.locator(headerUserEmail)).containsText(expectedLogin);
        return this;
    }
}
