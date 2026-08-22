package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

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

    public void clickOnGenderMaleRadioButton() {
        page.locator(genderMaleRadioButton).click();
    }

    public void clickOnGenderFemaleRadioButton() {
        page.locator(genderFemaleRadioButton).click();
    }

    public void fillFirstNameInput(String firstName) {
        page.locator(firstNameInput).fill(firstName);
    }

    public void fillLastNameInput(String lastName) {
        page.locator(lastNameInput).fill(lastName);
    }

    public void fillEmailInput(String email) {
        page.locator(emailInput).fill(email);
    }

    public void fillPasswordInput(String password) {
        page.locator(passwordInput).fill(password);
    }

    public void fillConfirmPasswordInput(String password) {
        page.locator(confirmPasswordInput).fill(password);
    }

    public void clickOnRegisterButton() {
        page.locator(registerButton).click();
    }

    public void registerAs(String firstName, String lastName, String email, String password) {
        clickOnGenderMaleRadioButton();
        fillFirstNameInput(firstName);
        fillLastNameInput(lastName);
        fillEmailInput(email);
        fillPasswordInput(password);
        fillConfirmPasswordInput(password);
        clickOnRegisterButton();
    }

    public void verifySuccessRegistration(String successText) {
        assertThat(page.locator(registerResult)).containsText(successText);
    }
}
