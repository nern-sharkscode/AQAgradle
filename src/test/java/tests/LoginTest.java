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
                        ConfigReader.getEmailForUserUnsuccessLogin(),
                        ConfigReader.getPasswordForUserUnsuccessLogin()
                },
                {
                        ConfigReader.getEmailForUserSuccessLogin(),
                        ConfigReader.getPasswordForUserUnsuccessLogin()
                },
                {
                        ConfigReader.getEmailForUserUnsuccessLogin(),
                        ConfigReader.getPasswordForUserUnsuccessLogin()
                }
        };
    }

    @Test(groups = "positive")
    public void successfulLogin() {
        LoginPage loginPage = new LoginPage(page);
        HomePage homePage = new HomePage(page);
        homePage.clickOnHeaderLoginButton();
        loginPage.loginAs(ConfigReader.getEmailForUserSuccessLogin(), ConfigReader.getPasswordForUserSuccessLogin());
        loginPage.verifySuccessLogin(ConfigReader.getEmailForUserSuccessLogin());
    }

    @Test(groups = "negative", dataProvider = "invalidCredentials")
    public void invalidLogin(String email, String password) {
        String failedLoginText = "Login was unsuccessful.";
        LoginPage loginPage = new LoginPage(page);
        HomePage homePage = new HomePage(page);
        homePage.clickOnHeaderLoginButton();
        loginPage.loginAs(email, password);
        loginPage.verifyValidationError(failedLoginText);
    }
}