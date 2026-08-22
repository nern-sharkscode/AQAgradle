package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LogoutTest extends BaseTest {
    @Test(groups = "positive")
    public void logoutTest() {
        HomePage homePage = new HomePage(page);
        LoginPage loginPage = new LoginPage(page);
        homePage.clickOnHeaderLoginButton();
        loginPage.loginAs(config.getProperty("emailForUserSuccessLogin"), config.getProperty("passwordForUserSuccessLogin"));
        homePage.clickOnLogoutButton();
        homePage.verifyLogoutButtonIsHidden();
    }
}
