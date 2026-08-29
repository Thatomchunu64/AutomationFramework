package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import testData.LoginCredentials;

public class LoginPage {

    WebDriver loginDriver;

    By loginPageValid = By.xpath("//div[@id = 'root']/div/div[contains(text(), 'Swag Labs')]");
    By loginUsername = By.xpath("//div[@class = 'login-box']/form/div/input[@id = 'user-name' ]");
    By loginPassword = By.id("password");
    By loginButton = By.id("login-button");
    By loginUsernameCredentials = By.xpath("//div[@class = 'login_credentials_wrap']/div/div[@id = 'login_credentials']");
    By loginPasswordCredential = By.xpath("//div[@class = 'login_credentials_wrap']/div/div[@class = 'login_password']");

    public LoginPage(WebDriver drive) {
        this.loginDriver = drive;
    }

    public void verifyLoginPage() {

        loginDriver.findElement(loginPageValid).isDisplayed();
        System.out.println("Login page verified");

    }

    public void verifyLoginCredentials() {

        Assert.assertTrue(loginDriver.findElement(loginUsernameCredentials).isDisplayed(), "cool");
        Assert.assertTrue(loginDriver.findElement(loginPasswordCredential).isDisplayed(), "cool");
        System.out.println("Login credentials present & verified ");//note redundancy

    }

    public void inputLoginUsername(String username) {

        loginDriver.findElement(loginUsername).sendKeys(username);

    }

    public void inputLoginPassword(String password) {

        loginDriver.findElement(loginPassword).sendKeys(password);

    }


    public void loginButtonClick() {

        loginDriver.findElement(loginButton).click();


    }


}
