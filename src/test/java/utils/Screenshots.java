package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {

    public static String getSnapshot(WebDriver driverSnap) {

        TakesScreenshot snapshot = (TakesScreenshot) driverSnap;
        String base64Code = snapshot.getScreenshotAs(OutputType.BASE64);
        

        return base64Code;


    }

}
