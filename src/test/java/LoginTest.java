import com.microsoft.playwright.Page;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTest extends BaseTest {

    @Test(groups = "positive")
    public void successfulLogin() {
        String userEmail = "firstUser321@gmail.com";
        String userPassword = "qwerty1";
        LoginPage loginPage = new LoginPage(page);
        HomePage homePage = new HomePage(page);
        page.navigate("/");
        homePage.clickOnHeaderLoginButton();
        loginPage.fillEmailInput(userEmail);
        loginPage.fillPasswordInput(userPassword);
        loginPage.clickOnLoginButton();
        assertThat(loginPage.getHeaderUserEmail()).hasText(userEmail);
    }

    @Test(groups = "negative")
    public void invalidLogin() {
        String failedLoginText = "Login was unsuccessful.";
        LoginPage loginPage = new LoginPage(page);
        HomePage homePage = new HomePage(page);
        page.navigate("/");
        homePage.clickOnHeaderLoginButton();
        loginPage.fillEmailInput("firstUser333@gmail.com");
        loginPage.fillPasswordInput("qwerty1");
        loginPage.clickOnLoginButton();
        assertThat(loginPage.getValidationSummaryErrors()).containsText(failedLoginText);
    }
}