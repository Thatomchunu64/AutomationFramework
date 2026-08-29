package testRunners;


import org.testng.annotations.Test;
import utils.Base;

public class SauceDemoLoginTest extends Base {


    @Test
    public void verifyLoginPageContent() throws InterruptedException {

        loginPage.verifyLoginPage();

        loginPage.verifyLoginCredentials();

        Thread.sleep(2000);


    }

    @Test(dependsOnMethods = "verifyLoginPageContent")
    public void enterLoginCredentials () throws InterruptedException {

        Thread.sleep(2000);
        loginPage.loginButtonClick();
        System.out.println("Logged in successfully");
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = "enterLoginCredentials" )
    public void verifyInventoryPageContent(){

        inventoryPage.verifyInventoryPage();

    }


}
