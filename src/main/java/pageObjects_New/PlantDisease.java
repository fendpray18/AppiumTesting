package pageObjects_New;

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

	@AndroidFindBy(id="com.android.farmdoctor:id/riv_plant_disease")
	public WebElement plantDisease;
	
	@AndroidFindBy(id="com.android.farmdoctor:id/search_button")
	public WebElement search;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Search Plant Disease Name']")
	public WebElement searchFieldDiseases;	
	
	
}
