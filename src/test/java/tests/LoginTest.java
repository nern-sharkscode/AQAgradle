package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTest extends BaseTest {

    @Test(groups = "positive")
    public void successfulLogin() {
        LoginPage loginPage = new LoginPage(page);
        HomePage homePage = new HomePage(page);
        homePage.clickOnHeaderLoginButton();
        loginPage.loginAs(ConfigReader.getPropertyFromConfig("emailForUserSuccessLogin"), ConfigReader.getPropertyFromConfig("passwordForUserSuccessLogin"));
        assertThat(loginPage.getHeaderUserEmail()).hasText(ConfigReader.getPropertyFromConfig("emailForUserSuccessLogin"));
    }

    @Test(groups = "negative")
    public void invalidLogin() {
        String failedLoginText = "Login was unsuccessful.";
        LoginPage loginPage = new LoginPage(page);
        HomePage homePage = new HomePage(page);
        homePage.clickOnHeaderLoginButton();
        loginPage.loginAs(ConfigReader.getPropertyFromConfig("emailForUserUnsuccessLogin"), ConfigReader.getPropertyFromConfig("passwordForUserUnsuccessLogin"));
        assertThat(loginPage.getValidationSummaryErrors()).containsText(failedLoginText);
    }
}