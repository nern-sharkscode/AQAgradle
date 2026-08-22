package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class RegisterTest extends BaseTest {
    Long timeMS = System.currentTimeMillis();
    String firstName = "User" + timeMS;
    String lastName = "First";
    String email = firstName + "@gmail.com";
    String password = "qwerty1";

    @Test(groups = "positive")
    public void SuccessfulRegistration() {
        String completedRegistration = "Your registration completed";
        HomePage homePage = new HomePage(page);
        RegisterPage registerPage = new RegisterPage(page);
        homePage.clickOnHeaderRegisterButton();
        registerPage.registerAs(firstName, lastName, email, password);
        registerPage.verifySuccessRegistration(completedRegistration);
    }
}
