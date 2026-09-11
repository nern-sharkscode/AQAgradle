package tests;

import facade.LoginFacade;
import facade.RegistrationFacade;
import models.UserRegistration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class RegisterTest extends BaseTest {
    private RegistrationFacade registerFacade;
    Long timeMS = System.currentTimeMillis();
    String firstName = "User" + timeMS;
    @BeforeMethod
    public void setUpFacade() {
        registerFacade = new RegistrationFacade(page);
    }

    UserRegistration newUser = UserRegistration.builder()
            .firstName(firstName)
            .lastName("First")
            .email(firstName + "@gmail.com")
            .password("qwerty1")
            .build();

    @Test(groups = "positive")
    public void SuccessfulRegistration() {
        String completedRegistration = "Your registration completed";
        HomePage homePage = new HomePage(page);
        RegisterPage registerPage = new RegisterPage(page);
        homePage.clickOnHeaderRegisterButton();
        registerFacade.registerAs(newUser);
        registerPage.verifySuccessRegistration(completedRegistration);
    }
}
