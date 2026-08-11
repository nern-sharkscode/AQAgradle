import com.microsoft.playwright.Page;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTest extends BaseTest {

    @Test(groups = "positive")
    public void successfulLogin() {
        LoginPage loginPage = new LoginPage(page);
        HomePage homePage = new HomePage(page);
        page.navigate("/");
        homePage.clickOnHeaderLoginButton();
        loginPage.fillEmailInput("firstUser321@gmail.com");
        loginPage.fillPasswordInput("qwerty1");
        loginPage.clickOnLoginButton();
        assertThat(page.locator(".header-links .account")).hasText("firstUser321@gmail.com");
    }

    @Test(groups = "negative")
    public void invalidLogin() {
        LoginPage loginPage = new LoginPage(page);
        HomePage homePage = new HomePage(page);
        page.navigate("/");
        homePage.clickOnHeaderLoginButton();
        loginPage.fillEmailInput("firstUser333@gmail.com");
        loginPage.fillPasswordInput("qwerty1");
        loginPage.clickOnLoginButton();
        assertThat(page.locator(".validation-summary-errors")).containsText("Login was unsuccessful.");
    }
}