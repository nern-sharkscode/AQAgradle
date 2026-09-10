package facade;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import models.UserRegistration;
import pages.RegisterPage;

public class RegistrationFacade {
    private final RegisterPage registerPage;

    public RegistrationFacade(Page page) {
        this.registerPage = new RegisterPage(page);
    }

    @Step("registerAs")
    public void registerAs(UserRegistration newUser) {
        registerPage
                .clickOnGenderMaleRadioButton()
                .fillFirstNameInput(newUser.getFirstName())
                .fillLastNameInput(newUser.getLastName())
                .fillEmailInput(newUser.getEmail())
                .fillPasswordInput(newUser.getPassword())
                .fillConfirmPasswordInput(newUser.getPassword())
                .clickOnRegisterButton();
    }
}
