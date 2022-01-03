package pageObjects_New;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SearchPlant {
	
	public SearchPlant(AndroidDriver<AndroidElement> driver) {
	
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id="com.android.farmdoctor:id/riv_search_plant")
	public WebElement searchPlantMenu;
	
	@AndroidFindBy(id="com.android.farmdoctor:id/search_button")
	public WebElement searchButton;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='   Search Plant Species']")
	public WebElement searchField;	
	
	@AndroidFindBy(id="com.android.farmdoctor:id/search_close_btn")
	public WebElement closeButton;
	
	@AndroidFindBy(xpath="//*[@content-desc='More options']")
	public WebElement moreOption;
}
