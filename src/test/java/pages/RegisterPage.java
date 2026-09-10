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
    public RegisterPage clickOnGenderMaleRadioButton() {
        click(genderMaleRadioButton);
        return this;
    }

    @Step("clickOnGenderFemaleRadioButton")
    public RegisterPage clickOnGenderFemaleRadioButton() {
        click(genderFemaleRadioButton);
        return this;
    }

    @Step("fillFirstNameInput")
    public RegisterPage fillFirstNameInput(String firstName) {
        fill(firstNameInput, firstName);
        return this;
    }

    @Step("fillLastNameInput")
    public RegisterPage fillLastNameInput(String lastName) {
        fill(lastNameInput, lastName);
        return this;
    }

    @Step("fillEmailInput")
    public RegisterPage fillEmailInput(String email) {
        fill(emailInput, email);
        return this;
    }

    @Step("fillPasswordInput")
    public RegisterPage fillPasswordInput(String password) {
        fill(passwordInput, password);
        return this;
    }

    @Step("fillConfirmPasswordInput")
    public RegisterPage fillConfirmPasswordInput(String password) {
        fill(confirmPasswordInput, password);
        return this;
    }

    @Step("clickOnRegisterButton")
    public RegisterPage clickOnRegisterButton() {
        click(registerButton);
        return this;
    }

    @Step("Verify if text about success registration is visible")
    public void verifySuccessRegistration(String successText) {
        assertThat(page.locator(registerResult)).containsText(successText);
    }
}
