package pageObjects_Old;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DiagnosePlant {
	public DiagnosePlant(AndroidDriver<AndroidElement> driver) {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id="com.android.plantdiseasesdetection:id/iv_detection")
	public WebElement diagnosePlant;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Kamera']")
	public WebElement optionKamera;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Gambar']")
	public WebElement optionGambar;
	
	@AndroidFindBy(className="android.widget.ImageButton")
	public WebElement backIcon;
	
}
