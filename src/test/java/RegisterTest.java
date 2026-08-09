import com.microsoft.playwright.Page;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class RegisterTest extends BaseTest {
    String firstName = "User";
    String lastName = "First";
    Long timeMS = System.currentTimeMillis();
    String email = "firstUser" + timeMS + "@gmail.com";
    String password = "qwerty1";

    @Test(groups = "positive")
    public void SuccessfulRegistration() {
        HomePage homePage = new HomePage(page);
        RegisterPage registerPage = new RegisterPage(page);
        page.navigate("/");
        homePage.clickOnHeaderRegisterButton();
        registerPage.clickOnGenderMaleRadioButton();
        registerPage.fillFirstNameInput(firstName);
        registerPage.fillLastNameInput(lastName);
        registerPage.fillEmailInput(email);
        registerPage.fillPasswordInput(password);
        registerPage.fillConfirmPasswordInput(password);
        registerPage.clickOnRegisterButton();
        assertThat(page.locator(".result")).hasText("Your registration completed");
    }
}
