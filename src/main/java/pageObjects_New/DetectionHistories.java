package pageObjects_New;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DetectionHistories {

	public DetectionHistories(AndroidDriver<AndroidElement> driver) {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id="com.android.farmdoctor:id/riv_detection_history")
	public WebElement detectionHistories;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@cotent-desc='More options']")
	public WebElement moreOption;
}

