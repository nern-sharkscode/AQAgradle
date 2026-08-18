package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTest extends BaseTest {

    @DataProvider(name = "invalidCredentials")
    public Object[][] getInvalidCredentials() {
        return new Object[][]{
                {
                        ConfigReader.getPropertyFromConfig("emailForUserUnsuccessLogin"),
                        ConfigReader.getPropertyFromConfig("passwordForUserUnsuccessLogin")
                },
                {
                        ConfigReader.getPropertyFromConfig("emailForUserSuccessLogin"), ConfigReader.getPropertyFromConfig("passwordForUserUnsuccessLogin")
                },
                {
                        ConfigReader.getPropertyFromConfig("emailForUserUnsuccessLogin"), ConfigReader.getPropertyFromConfig("passwordForUserSuccessLogin")
                }
        };
    }

    @Test(groups = "positive")
    public void successfulLogin() {
        LoginPage loginPage = new LoginPage(page);
        HomePage homePage = new HomePage(page);
        homePage.clickOnHeaderLoginButton();
        loginPage.loginAs(ConfigReader.getPropertyFromConfig("emailForUserSuccessLogin"), ConfigReader.getPropertyFromConfig("passwordForUserSuccessLogin"));
        assertThat(loginPage.getHeaderUserEmail()).hasText(ConfigReader.getPropertyFromConfig("emailForUserSuccessLogin"));
    }

    @Test(groups = "negative", dataProvider = "invalidCredentials")
    public void invalidLogin(String email, String password) {
        String failedLoginText = "Login was unsuccessful.";
        LoginPage loginPage = new LoginPage(page);
        HomePage homePage = new HomePage(page);
        homePage.clickOnHeaderLoginButton();
        loginPage.loginAs(email, password);
        assertThat(loginPage.getValidationSummaryErrors()).containsText(failedLoginText);
    }
}