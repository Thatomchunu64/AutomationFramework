package testRunners;

import org.testng.annotations.Test;
import testData.LoginCredentials;
import utils.Base;

public class SauceDemoAddItemsTest extends Base {

    @Test
    public void verifyLoginPageContent() {

        loginPage.verifyLoginPage();
        loginPage.verifyLoginCredentials();

    }

    @Test
    public void verifyUserCanAddProductsToCart() throws InterruptedException {

        // Login
        loginPage.inputLoginUsername(LoginCredentials.standardUsername);
        loginPage.inputLoginPassword(LoginCredentials.universalPassword);
        loginPage.loginButtonClick();

        // Verify inventory page
        inventoryPage.verifyInventoryPage();

        // Add products
        inventoryPage.addProductToCart("bike");
        inventoryPage.addProductToCart("backpack");
        inventoryPage.addProductToCart("Jacket66");

        // View cart
        inventoryPage.clickCartIcon();

        Thread.sleep(2000);
    }


}
