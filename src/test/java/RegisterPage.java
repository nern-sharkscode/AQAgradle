import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class RegisterPage {
    private final Page page;
    private final Locator genderMaleRadioButton;
    private final Locator genderFemaleRadioButton;
    private final Locator firstNameInput;
    private final Locator lastNameInput;
    private final Locator emailInput;
    private final Locator passwordInput;
    private final Locator confirmPasswordInput;
    private final Locator registerButton;

    public RegisterPage(Page page) {
        this.page = page;
        this.genderMaleRadioButton = page.locator("#gender-male");
        this.genderFemaleRadioButton = page.locator("#gender-female");
        this.firstNameInput = page.locator("#FirstName");
        this.lastNameInput = page.locator("#LastName");
        this.emailInput = page.locator("#Email");
        this.passwordInput = page.locator("#Password");
        this.confirmPasswordInput = page.locator("#ConfirmPassword");
        this.registerButton = page.locator("#register-button");
    }

    public void clickOnGenderMaleRadioButton() {
        genderMaleRadioButton.click();
    }

    public void clickOnGenderFemaleRadioButton() {
        genderFemaleRadioButton.click();
    }

    public void fillFirstNameInput(String firstName) {
        firstNameInput.fill(firstName);
    }

    public void fillLastNameInput(String lastName) {
        lastNameInput.fill(lastName);
    }

    public void fillEmailInput(String email) {
        emailInput.fill(email);
    }

    public void fillPasswordInput(String password) {
        passwordInput.fill(password);
    }

    public void fillConfirmPasswordInput(String password) {
        confirmPasswordInput.fill(password);
    }

    public void clickOnRegisterButton() {
        registerButton.click();
    }
}
