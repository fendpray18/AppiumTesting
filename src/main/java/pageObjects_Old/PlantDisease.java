package pageObjects_Old;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PlantDisease {

	public PlantDisease(AndroidDriver<AndroidElement> driver) {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id="com.android.plantdiseasesdetection:id/iv_list")
	public WebElement plantDisease;
	
	@AndroidFindBy(className="android.widget.TextView")
	public WebElement search;
	
	@AndroidFindBy(id="android:id/search_button")
	public WebElement searchButton;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='   Cari Nama Penyakit Tanaman']")
	public WebElement searchFieldDiseases;	
	
	@AndroidFindBy(xpath="//*[@content-desc='More options']")
	public WebElement moreOption;
	
	
}
