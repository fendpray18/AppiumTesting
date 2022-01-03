package scenarios;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import resources.base;

public class ApiApp extends base {

	@Test
	public void scenarioFirstApp() throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		service = startServer();

		AndroidDriver<AndroidElement> driver = capabilities("ApiDebug");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();
		Thread.sleep(5000);
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

		service.stop();
	}
	
	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException
	{
	//taskkill /F /IM node.exe
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
		
	}

}
