package testRunners;

import org.testng.annotations.Test;
import testData.LoginCredentials;
import utils.Base;

public class LoginTests extends Base {

    @Test
    public void verifyLoginPageContent() throws InterruptedException {

        loginPage.verifyLoginPage();
        loginPage.verifyLoginCredentials();
        Thread.sleep(2000);

    }

    @Test
    public void standardUserLogin() throws InterruptedException {

        loginPage.inputLoginUsername(LoginCredentials.standardUsername);
        loginPage.inputLoginPassword(LoginCredentials.universalPassword);
        loginPage.loginButtonClick();
        Thread.sleep(2000);
    }

    @Test
    public void errorUserLogin() throws InterruptedException {

        loginPage.inputLoginUsername(LoginCredentials.errorUsername);
        loginPage.inputLoginPassword(LoginCredentials.universalPassword);
        loginPage.loginButtonClick();
        Thread.sleep(2000);
    }

    @Test
    public void lockedOutUserLogin() throws InterruptedException {

        loginPage.inputLoginUsername(LoginCredentials.lockedOutUsername);
        loginPage.inputLoginPassword(LoginCredentials.universalPassword);
        loginPage.loginButtonClick();
        Thread.sleep(2000);
    }

    @Test
    public void performanceGlitchUserLogin() throws InterruptedException {

        loginPage.inputLoginUsername(LoginCredentials.performanceGlitchUsername);
        loginPage.inputLoginPassword(LoginCredentials.universalPassword);
        loginPage.loginButtonClick();
        Thread.sleep(2000);
    }

    @Test
    public void problemUserLogin() throws InterruptedException {

        loginPage.inputLoginUsername(LoginCredentials.problemUsername);
        loginPage.inputLoginPassword(LoginCredentials.universalPassword);
        loginPage.loginButtonClick();
        Thread.sleep(2000);
    }

    @Test
    public void visualUserLogin() throws InterruptedException {

        loginPage.inputLoginUsername(LoginCredentials.visualUsername);
        loginPage.inputLoginPassword(LoginCredentials.universalPassword);
        loginPage.loginButtonClick();
        Thread.sleep(2000);
    }

    @Test
    public void invalidUserLogin() throws InterruptedException {

        loginPage.inputLoginUsername(LoginCredentials.invalidUsername);
        loginPage.inputLoginPassword(LoginCredentials.universalPassword);
        loginPage.loginButtonClick();
        Thread.sleep(2000);
    }

}
