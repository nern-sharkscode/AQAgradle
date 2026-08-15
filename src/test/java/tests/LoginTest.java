package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTest extends BaseTest {

    @Test(groups = "positive")
    public void successfulLogin() {
        LoginPage loginPage = new LoginPage(page);
        HomePage homePage = new HomePage(page);
        homePage.clickOnHeaderLoginButton();
        loginPage.loginAs(config.getProperty("emailForUserSuccessLogin"), config.getProperty("passwordForUserSuccessLogin"));
        assertThat(loginPage.getHeaderUserEmail()).hasText(config.getProperty("emailForUserSuccessLogin"));
    }

    @Test(groups = "negative")
    public void invalidLogin() {
        String failedLoginText = "Login was unsuccessful.";
        LoginPage loginPage = new LoginPage(page);
        HomePage homePage = new HomePage(page);
        homePage.clickOnHeaderLoginButton();
        loginPage.loginAs(config.getProperty("emailForUserUnsuccessLogin"), config.getProperty("passwordForUserUnsuccessLogin"));
        assertThat(loginPage.getValidationSummaryErrors()).containsText(failedLoginText);
    }
}