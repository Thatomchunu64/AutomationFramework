package testRunners;

import org.testng.annotations.Test;
import utils.Base;

public class SauceDemoAddItemsTest extends Base {

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

    @Test(dependsOnMethods = "enterLoginCredentials" )
    public void verifyInventoryPageContent(){
        inventoryPage.verifyInventoryPage();

    }

    @Test(dependsOnMethods = "verifyInventoryPageContent" )
    public void AddItems(){

        inventoryPage.addProductToCart("bike");
        inventoryPage.addProductToCart("backpack");
        inventoryPage.addProductToCart("Jacket");

    }

    @Test(dependsOnMethods ="AddItems" )
    public void viewCartItems() {

        inventoryPage.clickCartIcon();

    }


}
