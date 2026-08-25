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

    static WebDriver driverFactory;


    static WebDriver launchBrowser(String browserName, String websiteUrl) {

        if (browserName.equalsIgnoreCase("Chrome")) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("--disable-notifications");

            driverFactory = new ChromeDriver(options);
            driverFactory.manage().window().maximize();
            driverFactory.get(websiteUrl);
            driverFactory.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        } else if (browserName.equalsIgnoreCase("safari")) {

            driverFactory = new SafariDriver();
            driverFactory.manage().window().maximize();
            driverFactory.get(websiteUrl);
            driverFactory.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        } else if (browserName.equalsIgnoreCase("firefox")) {

            FirefoxOptions fireOptions = new FirefoxOptions();
            fireOptions.addArguments("--incognito");

            driverFactory = new FirefoxDriver(fireOptions);
            driverFactory.manage().window().maximize();
            driverFactory.get(websiteUrl);
            driverFactory.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        } else {
            EdgeOptions edgeOpt = new EdgeOptions();
            edgeOpt.addArguments("--incognito");

            driverFactory = new EdgeDriver(edgeOpt);
            driverFactory.manage().window().maximize();
            driverFactory.get(websiteUrl);
            driverFactory.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        return driverFactory;
    }

    public static void tearDownBrowser() {

        if (driverFactory != null) {

            driverFactory.quit();
        }
    }

}
