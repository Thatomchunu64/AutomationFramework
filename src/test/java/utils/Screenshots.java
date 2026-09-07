package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {

    public static String getSnapshot(WebDriver driverSnap) {

        TakesScreenshot snapshot = (TakesScreenshot) driverSnap;
        return snapshot.getScreenshotAs(OutputType.BASE64);

        /*
        String base64Code = snapshot.getScreenshotAs(OutputType.BASE64):
        Declaring a variable only to immediately return or throw it is considered a bad practice because it adds unnecessary complexity to the code.
        This practice can make the code harder to read and understand, as it introduces an extra step that doesn’t add any value.
        Instead of declaring a variable and then immediately returning or throwing it, it is generally better to return or throw the value directly.
        This makes the code cleaner, simpler, and easier to understand.
         */


    }

}
