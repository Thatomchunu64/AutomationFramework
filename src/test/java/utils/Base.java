package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.InventoryPage;
import pages.LoginPage;

public class Base {

    public static WebDriver driverBase;
    public static LoginPage loginPage;
    public static InventoryPage inventoryPage;

    //public static final WebDriver driverBase = BrowserFactory.launchBrowser("chrome", "https://www.saucedemo.com/");


    @BeforeMethod
    public void setUp() {

        driverBase = BrowserFactory.launchBrowser("chrome", "https://www.saucedemo.com/");
        loginPage = PageFactory.initElements(driverBase, LoginPage.class);
        inventoryPage = PageFactory.initElements(driverBase, InventoryPage.class);
    }

    @AfterMethod
    public void tearDown() {

        BrowserFactory.tearDownBrowser();
        System.out.println("TEST ENDED SUCCESSFULLY");
    }


}
