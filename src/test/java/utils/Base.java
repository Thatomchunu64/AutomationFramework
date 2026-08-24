package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;

public class Base {

    public static final WebDriver driverBase = BrowserFactory.launchBrowser("chrome","https://www.saucedemo.com/");


    public static LoginPage loginPage = PageFactory.initElements(driverBase, LoginPage.class);

}
