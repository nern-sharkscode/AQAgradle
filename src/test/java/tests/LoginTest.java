package tests;

import facade.LoginFacade;
import models.UserLogin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTest extends BaseTest {
    private LoginFacade loginFacade;

    @BeforeMethod
    public void setUpFacade() {
        loginFacade = new LoginFacade(page);
    }

    @DataProvider(name = "invalidCredentials")
    public Object[][] getInvalidCredentials() {
        return new Object[][]{
                {
                        UserLogin.builder()
                                .setEmail(ConfigReader.getEmailForUserUnsuccessLogin())
                                .setPassword(ConfigReader.getPasswordForUserUnsuccessLogin())
                                .build()
                },
                {
                        UserLogin.builder()
                                .setEmail(ConfigReader.getEmailForUserSuccessLogin())
                                .setPassword(ConfigReader.getPasswordForUserUnsuccessLogin())
                                .build()
                },
                {
                        UserLogin.builder()
                                .setEmail(ConfigReader.getEmailForUserUnsuccessLogin())
                                .setPassword(ConfigReader.getPasswordForUserSuccessLogin())
                                .build()
                }
        };
    }

    @Test(groups = "positive")
    public void successfulLogin() {
        UserLogin validUser = UserLogin.builder()
                .setEmail(ConfigReader.getEmailForUserSuccessLogin())
                .setPassword(ConfigReader.getPasswordForUserSuccessLogin())
                .build();
        LoginPage loginPage = new LoginPage(page);
        HomePage homePage = new HomePage(page);
        homePage.clickOnHeaderLoginButton();
        loginFacade.loginAs(validUser);
        loginPage.verifySuccessLogin(ConfigReader.getEmailForUserSuccessLogin());
    }

    @Test(groups = "negative", dataProvider = "invalidCredentials")
    public void invalidLogin(UserLogin user) {
        String failedLoginText = "Login was unsuccessful.";
        LoginPage loginPage = new LoginPage(page);
        HomePage homePage = new HomePage(page);
        homePage.clickOnHeaderLoginButton();
        loginFacade.loginAs(user);
        loginPage.verifyValidationError(failedLoginText);
    }
}