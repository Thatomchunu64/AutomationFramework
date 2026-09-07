package testRunners;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testData.ReadFromDatabase;
import utils.Base;

public class SauceDemoAddItemsTest extends Base {

    @BeforeClass
    public void dbSetup(){
        ReadFromDatabase.databaseConnect();
    }

    @Test
    public void verifyLoginPageContent() {

        loginPage.verifyLoginPage();
        loginPage.verifyLoginCredentials();

    }

    @Test
    public void verifyUserCanAddProductsToCart() {

        // Login
        loginPage.inputLoginUsername(ReadFromDatabase.getUsername);
        loginPage.inputLoginPassword(ReadFromDatabase.getPassword);
        loginPage.loginButtonClick();

        // Verify inventory page
        inventoryPage.verifyInventoryPage();

        // Add products
        inventoryPage.addProductToCart("bike");
        inventoryPage.addProductToCart("backpack");
        inventoryPage.addProductToCart("Jacket");

        // View cart
        inventoryPage.clickCartIcon();


    }


}
