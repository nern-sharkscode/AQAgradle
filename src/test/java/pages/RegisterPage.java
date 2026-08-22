package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class RegisterPage extends BasePage {
    private static final String genderMaleRadioButton = "#gender-male";
    private static final String genderFemaleRadioButton = "#gender-female";
    private static final String firstNameInput = "#FirstName";
    private static final String lastNameInput = "#LastName";
    private static final String emailInput = "#Email";
    private static final String passwordInput = "#Password";
    private static final String confirmPasswordInput = "#ConfirmPassword";
    private static final String registerButton = "#register-button";
    private static final String registerResult = ".result";

    public RegisterPage(Page page) {
        super(page);
    }

    @Step("clickOnGenderMaleRadioButton")
    public void clickOnGenderMaleRadioButton() {
        page.locator(genderMaleRadioButton).click();
    }

    @Step("clickOnGenderFemaleRadioButton")
    public void clickOnGenderFemaleRadioButton() {
        page.locator(genderFemaleRadioButton).click();
    }

    @Step("fillFirstNameInput")
    public void fillFirstNameInput(String firstName) {
        page.locator(firstNameInput).fill(firstName);
    }

    @Step("fillLastNameInput")
    public void fillLastNameInput(String lastName) {
        page.locator(lastNameInput).fill(lastName);
    }

    @Step("fillEmailInput")
    public void fillEmailInput(String email) {
        page.locator(emailInput).fill(email);
    }

    @Step("fillPasswordInput")
    public void fillPasswordInput(String password) {
        page.locator(passwordInput).fill(password);
    }

    @Step("fillConfirmPasswordInput")
    public void fillConfirmPasswordInput(String password) {
        page.locator(confirmPasswordInput).fill(password);
    }

    @Step("clickOnRegisterButton")
    public void clickOnRegisterButton() {
        page.locator(registerButton).click();
    }

    @Step("registerAs")
    public void registerAs(String firstName, String lastName, String email, String password) {
        clickOnGenderMaleRadioButton();
        fillFirstNameInput(firstName);
        fillLastNameInput(lastName);
        fillEmailInput(email);
        fillPasswordInput(password);
        fillConfirmPasswordInput(password);
        clickOnRegisterButton();
    }

    @Step("Verify if text about success registration is visible")
    public void verifySuccessRegistration(String successText) {
        assertThat(page.locator(registerResult)).containsText(successText);
    }
}
