package testRunners;

import org.testng.annotations.Test;
import testData.LoginCredentials;
import utils.Base;

public class SauceDemoAddItemsTest extends Base {

    @Test
    public void verifyLoginPageContent(){

        loginPage.verifyLoginPage();
        loginPage.verifyLoginCredentials();

    }

    @Test(dependsOnMethods = "verifyLoginPageContent")
    public void enterLoginCredentials () throws InterruptedException {

        loginPage.inputLoginUsername(LoginCredentials.standardUsername);
        loginPage.inputLoginPassword(LoginCredentials.universalPassword);
        loginPage.loginButtonClick();
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = "enterLoginCredentials" )
    public void verifyInventoryPageContent() throws InterruptedException {
        inventoryPage.verifyInventoryPage();
        Thread.sleep(2000);

    }

    @Test(dependsOnMethods = "verifyInventoryPageContent" )
    public void AddItems() throws InterruptedException {

        inventoryPage.addProductToCart("bike");
        inventoryPage.addProductToCart("backpack");
        inventoryPage.addProductToCart("Jacket");

        Thread.sleep(2000);
    }

    @Test(dependsOnMethods ="AddItems" )
    public void viewCartItems() throws InterruptedException {

        inventoryPage.clickCartIcon();
        Thread.sleep(2000);

    }


}
