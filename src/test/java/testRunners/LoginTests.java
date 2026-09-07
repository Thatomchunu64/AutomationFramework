package testRunners;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testData.LoginCredentials;
import testData.ReadFromDatabase;
import utils.Base;

public class LoginTests extends Base {

    @BeforeClass
    public void dbSetup() {
        ReadFromDatabase.databaseConnect();
    }

    @Test
    public void verifyLoginPageContent() {

        loginPage.verifyLoginPage();
        loginPage.verifyLoginCredentials();


    }

    @Test
    public void standardUserLogin() {

        loginPage.inputLoginUsername(ReadFromDatabase.getUsername);
        loginPage.inputLoginPassword(ReadFromDatabase.getPassword);
        loginPage.loginButtonClick();
    }

    @Test
    public void errorUserLogin() {

        loginPage.inputLoginUsername(LoginCredentials.errorUsername);
        loginPage.inputLoginPassword(LoginCredentials.universalPassword);
        loginPage.loginButtonClick();

    }

    @Test
    public void lockedOutUserLogin() {

        loginPage.inputLoginUsername(LoginCredentials.lockedOutUsername);
        loginPage.inputLoginPassword(LoginCredentials.universalPassword);
        loginPage.loginButtonClick();

    }

    @Test
    public void performanceGlitchUserLogin() {

        loginPage.inputLoginUsername(LoginCredentials.performanceGlitchUsername);
        loginPage.inputLoginPassword(LoginCredentials.universalPassword);
        loginPage.loginButtonClick();

    }

    @Test
    public void problemUserLogin() {

        loginPage.inputLoginUsername(LoginCredentials.problemUsername);
        loginPage.inputLoginPassword(LoginCredentials.universalPassword);
        loginPage.loginButtonClick();

    }

    @Test
    public void visualUserLogin() {

        loginPage.inputLoginUsername(LoginCredentials.visualUsername);
        loginPage.inputLoginPassword(LoginCredentials.universalPassword);
        loginPage.loginButtonClick();

    }

    @Test
    public void invalidUserLogin() {

        loginPage.inputLoginUsername(LoginCredentials.invalidUsername);
        loginPage.inputLoginPassword(LoginCredentials.universalPassword);
        loginPage.loginButtonClick();

    }

}
