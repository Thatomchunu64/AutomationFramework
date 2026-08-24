package testRunners;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.Base;

public class SauceDemoLoginTest extends Base {


    @Test
    public void verifyLoginPageContent(){

        loginPage.verifyLoginPage();
        loginPage.verifyLoginCredentials();

    }

    @Test(dependsOnMethods = "verifyLoginPageContent")
    public void enterLoginCredentials () throws InterruptedException {

        loginPage.standardUserLoginInput();
        loginPage.loginButtonClick();
    }
}
