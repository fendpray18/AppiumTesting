package pageObjects_General;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Scrolling {
	AndroidDriver<AndroidElement>  driver;

	public Scrolling(AndroidDriver<AndroidElement> driver)
	{
		this.driver=driver;
	}

	
	public void scrollToText(String text)
	{
	     driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(textContains(\""+text+"\"));");
	}
}
