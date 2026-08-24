package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;


import java.time.Duration;

public class BrowserFactory {

    static WebDriver driver;



    static WebDriver launchBrowser(String browserName, String websiteUrl){

        if (browserName.equalsIgnoreCase("Chrome")) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.get(websiteUrl);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        } else if (browserName.equalsIgnoreCase("safari")) {

            driver = new SafariDriver();
            driver.manage().window().maximize();
            driver.get(websiteUrl);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        } else if (browserName.equalsIgnoreCase("firefox")) {

            FirefoxOptions fireOptions = new FirefoxOptions();
            fireOptions.addArguments("--incognito");

            driver = new FirefoxDriver(fireOptions);
            driver.manage().window().maximize();
            driver.get(websiteUrl);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        }else {
            EdgeOptions edgeOpt = new EdgeOptions();
            edgeOpt.addArguments("--incognito");

            driver = new EdgeDriver(edgeOpt);
            driver.manage().window().maximize();
            driver.get(websiteUrl);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        return driver;
    }

}
