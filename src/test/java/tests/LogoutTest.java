package tests;

import facade.LoginFacade;
import models.UserLogin;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LogoutTest extends BaseTest {
    private LoginFacade loginFacade;

    @BeforeMethod
    public void setUpFacade() {
        loginFacade = new LoginFacade(page);
    }

    @Test(groups = "positive")
    public void logoutTest() {
        UserLogin validUser = UserLogin.builder()
                .setEmail(ConfigReader.getEmailForUserSuccessLogin())
                .setPassword(ConfigReader.getPasswordForUserSuccessLogin())
                .build();
        HomePage homePage = new HomePage(page);
        homePage.clickOnHeaderLoginButton();
        loginFacade.loginAs(validUser);
        homePage.clickOnLogoutButton();
        homePage.verifyLogoutButtonIsHidden();
    }
}
