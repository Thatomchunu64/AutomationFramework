package extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.Base;
import utils.BrowserFactory;
import utils.Screenshots;


public class ExtentReportManager implements ITestListener {

    private static ExtentReports extent; // Populate common info to the report
    private static ExtentTest test; // Creates test cases in the report


    @Override
    public void onStart(ITestContext context) {

        // UI of the reporter
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/Execution-Report.xml");
        sparkReporter.config().setDocumentTitle("Sauce Demo Automation");
        sparkReporter.config().setReportName("Functional-Tests");
        sparkReporter.config().setTheme(Theme.STANDARD);

        extent= new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Operating System",System.getProperty("os.name"));
        extent.setSystemInfo("Execution Machine",System.getProperty("user.name"));
        extent.setSystemInfo("Browser","Chrome");
        extent.setSystemInfo("Test Environment","Staging");

    }

    @Override
    public void onTestFailure(ITestResult result){

        test= extent.createTest(result.getName());
        test.log(Status.FAIL,"Test case "+ result.getMethod().getMethodName()+" has failed");
        test.log(Status.FAIL, result.getThrowable()); // will get us some errors that caused test to fail
        test.addScreenCaptureFromBase64String(Screenshots.getSnapshot(BrowserFactory.driverFactory), result.getName());

    }

    @Override
    public void onTestSuccess(ITestResult result){

        test= extent.createTest(result.getName());
        test.log(Status.PASS, "Test case "+ result.getMethod().getMethodName()+ " passed successfully");


    }

    @Override
    public void onTestSkipped(ITestResult result){

        test= extent.createTest(result.getName());
        test.log(Status.SKIP, "Test case "+ result.getMethod().getMethodName());

    }

    @Override
    public void onFinish(ITestContext context){
        extent.flush();

    }

}
