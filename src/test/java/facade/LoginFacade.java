package facade;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import models.UserLogin;
import pages.LoginPage;

public class LoginFacade {
    private final LoginPage loginPage;

    public LoginFacade(Page page) {
        this.loginPage = new LoginPage(page);
    }

    @Step("loginAs")
    public void loginAs(UserLogin user) {
        loginPage.fillEmailInput(user.getEmail())
                 .fillPasswordInput(user.getPassword())
                 .clickOnLoginButton();
    }
}
