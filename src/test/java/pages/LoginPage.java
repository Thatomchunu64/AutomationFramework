package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver loginDriver;

    By loginPageValid = By.xpath("//div[@id = 'root']/div/div[contains(text(), 'Swag Labs')]");
    By loginUsername = By.xpath("//div[@class = 'login-box']/form/div/input[@id = 'user-name' ]");
    By loginPassword = By.id("password");
    By loginButton = By.id("login-button");
    By loginUsernameCredentials = By.xpath("//div[@class = 'login_credentials_wrap']/div/div[@id = 'login_credentials']");
    By loginPasswordCredential = By.xpath("//div[@class = 'login_credentials_wrap']/div/div[@class = 'login_password']");

    public LoginPage(WebDriver drive){
        this.loginDriver = drive;
    }

    public void verifyLoginPage(){

        loginDriver.findElement(loginPageValid).isDisplayed();
        System.out.println("Login page verified");

    }

    public void verifyLoginCredentials(){

        loginDriver.findElement(loginUsernameCredentials).isDisplayed();
        loginDriver.findElement(loginPasswordCredential).isDisplayed();
        System.out.println("Login credentials present & verified ");

    }

    public void standardUserLoginInput() throws InterruptedException {

        loginDriver.findElement(loginUsername).sendKeys("standard_user");
        loginDriver.findElement(loginPassword).sendKeys("secret_sauce");
        Thread.sleep(2000);

    }

    public void lockedOutUserLoginInput() throws InterruptedException {

        loginDriver.findElement(loginUsername).sendKeys("locked_out_user");
        loginDriver.findElement(loginPassword).sendKeys("secret_sauce");
        Thread.sleep(2000);

    }

    public void errorUserLoginInput() throws InterruptedException {

        loginDriver.findElement(loginUsername).sendKeys("error_user");
        loginDriver.findElement(loginPassword).sendKeys("secret_sauce");
        Thread.sleep(2000);

    }

    public void problemUserLoginInput() throws InterruptedException {

        loginDriver.findElement(loginUsername).sendKeys("problem_user");
        loginDriver.findElement(loginPassword).sendKeys("secret_sauce");
        Thread.sleep(2000);

    }

    public void performanceGlitchUserLoginInput() throws InterruptedException {

        loginDriver.findElement(loginUsername).sendKeys("performance_glitch_user");
        loginDriver.findElement(loginPassword).sendKeys("secret_sauce");
        Thread.sleep(2000);

    }

    public void visualUserLoginInput() throws InterruptedException {


        loginDriver.findElement(loginUsername).sendKeys("visual_user");
        loginDriver.findElement(loginPassword).sendKeys("secret_sauce");
        Thread.sleep(2000);

    }

    public void loginButtonClick(){

        loginDriver.findElement(loginButton).click();
        System.out.println("User logged in");

    }







}
