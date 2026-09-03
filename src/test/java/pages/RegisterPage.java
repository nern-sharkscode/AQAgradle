package pages;

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
        click(genderMaleRadioButton);
    }

    @Step("clickOnGenderFemaleRadioButton")
    public void clickOnGenderFemaleRadioButton() {
        click(genderFemaleRadioButton);
    }

    @Step("fillFirstNameInput")
    public void fillFirstNameInput(String firstName) {
        fill(firstNameInput, firstName);
    }

    @Step("fillLastNameInput")
    public void fillLastNameInput(String lastName) {
        fill(lastNameInput, lastName);
    }

    @Step("fillEmailInput")
    public void fillEmailInput(String email) {
        fill(emailInput, email);
    }

    @Step("fillPasswordInput")
    public void fillPasswordInput(String password) {
        fill(passwordInput, password);
    }

    @Step("fillConfirmPasswordInput")
    public void fillConfirmPasswordInput(String password) {
        fill(confirmPasswordInput, password);
    }

    @Step("clickOnRegisterButton")
    public void clickOnRegisterButton() {
        click(registerButton);
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
