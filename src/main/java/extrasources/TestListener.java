package extrasources;

import java.io.IOException;
import org.testng.ITestContext ;		
import org.testng.ITestListener ;		
import org.testng.ITestResult ;	

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import resources.base;

public class TestListener extends base implements ITestListener
{
	ExtentTest test;
	ExtentReports extent=ExtentReporterNG.getReportObject();
	AndroidDriver<AndroidElement> driver;
	
	//To Test File Class with parallel testing, then should insert script "ThreadLocal" execution
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	//after declare "extentTest", we use in all logs like Start, Success, Failure, Finish
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		//To create Reports on Website using "Listeners", should starting in "OnTestStart"
		//we create syntax to starting test based Listeners
		test=extent.createTest(result.getMethod().getMethodName());//calling based methods class
		
		//declare object extentTest in Start Step
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		//appear output if success in index.html ("detail") using this syntax :
		//declare object extentTest in Success
		extentTest.get().log(Status.PASS, "Test Passed");

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		//appear output if failed in index.html using this syntax :
		//declare object extentTest in Failure
		extentTest.get().fail(result.getThrowable()); //Showing the error script in Report
		
		//Have been used to get Screenshot (can without Extentreports)
		driver=null; //try to make driver to be null 
		//Get file class failure is (just places)
		String testMethodName=result.getMethod().getMethodName();
		
		try {
			//give the life/information file class
			driver = (AndroidDriver<AndroidElement>) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch(Exception e)
		{	
		}
		try {
			//Try to get Screenshot in ExtentReport index.hml
			extentTest.get().addScreenCaptureFromPath(
					getScreenshotPath(testMethodName, driver), 
					result.getMethod().getMethodName()); //(Placed Failure, Info/Life)
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		//must write syntax "flush()"
		extent.flush(); //as the end of test to store all test logs to report files
	}
	
}