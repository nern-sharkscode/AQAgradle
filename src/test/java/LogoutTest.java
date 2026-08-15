import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LogoutTest extends BaseTest {
    @Test(groups = "positive")
    public void logoutTest(){
        HomePage homePage = new HomePage(page);
        LoginPage loginPage = new LoginPage(page);
        page.navigate("/");
        homePage.clickOnHeaderLoginButton();
        loginPage.fillEmailInput("firstUser321@gmail.com");
        loginPage.fillPasswordInput("qwerty1");
        loginPage.clickOnLoginButton();
        homePage.clickOnLogoutButton();
        assertThat(homePage.getLogOutButton()).isHidden();
    }
}
