package scenarios;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pageObjects_General.PopUpAllow;
import pageObjects_New.DetectionHistories;
import pageObjects_New.DiagnosePlant;
import pageObjects_New.PlantDisease;
import pageObjects_New.SearchPlant;
import extrasources.TestData;
import resources.base;

public class FarmDoctorNew extends base {

	@Test(dataProvider="InputData",dataProviderClass=TestData.class)
	public void scenarioSecondApp(String input) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		service = startServer();

		AndroidDriver<AndroidElement> driver = capabilities("FarmAppNew");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		/*
		 * SearchPlant new_search=new SearchPlant(driver);
		 * new_search.searchPlantMenu.click(); new_search.searchButton.click();
		 * new_search.searchField.sendKeys("Apple", Keys.ENTER); driver.hideKeyboard();
		 * Thread.sleep(5000);
		 * 
		 * new_search.closeButton.click(); new_search.searchField.sendKeys("Flower",
		 * Keys.ENTER); driver.hideKeyboard(); Thread.sleep(5000);
		 * 
		 * new_search.closeButton.click();
		 * 
		 * //new_search.moreOption.click(); //driver.pressKey(new
		 * KeyEvent(AndroidKey.BACK)); //driver.sendKeyEvent(AndroidKeyCode.BACK);
		 * driver.pressKey(new KeyEvent(AndroidKey.BACK)); //driver.navigate().back();
		 * 
		 * DetectionHistories new_detec=new DetectionHistories(driver);
		 * new_detec.detectionHistories.click(); Thread.sleep(5000);
		 * //new_detec.moreOption.click();
		 * 
		 * driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 * 
		 * DiagnosePlant new_diagP=new DiagnosePlant(driver);
		 * new_diagP.diagnosePlant.click(); Thread.sleep(5000);
		 * 
		 * PopUpAllow popUp=new PopUpAllow(driver); popUp.popUpAllow.click();
		 * 
		 * driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 */
		PlantDisease new_Plant = new PlantDisease(driver);
		new_Plant.plantDisease.click();
		Thread.sleep(5000);
		
		new_Plant.search.click();
		new_Plant.searchFieldDiseases.sendKeys(input);
		//android.widget.FrameLayout
		driver.hideKeyboard();
		
		Thread.sleep(5000);
		
		//driver.findElement(MobileBy.AndroidUIAutomator("textContains(\""+input+"\")")).click();
		
		// com.android.plantdiseasesdetection:id/tv_item_name
		//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.android.farmdoctor:id/rv_list_diseases\")).scrollIntoView(new UiSelector().textContains(\""+input+"\").instance(0))")).click();

		// old_pd.search.sendKeys("Corn Northern Leaf Blight", Keys.ENTER);
		int count = driver.findElements(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView")).size();

		System.out.println("FrameLayout "+input+count);
		
		for (int i = 0; i < count; i++)

		{

			String text = driver.findElements(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView")).get(i).getText();

			//method 'equalsignorecase' is used for ignore uppre or lower letter
			if (text.equalsIgnoreCase(input))

			{

				driver.findElements(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView")).get(i).click();
				
				//Scroll Down
				driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));

				//Scroll Up
				driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollBackward()"));
				
				break;

			}

		}
		
		
		Thread.sleep(5000);
		
		/*Dimension size= driver.manage().window().getSize();
		
		int x = size.getWidth()/2;
		
		int starty= (int)(size.getHeight()*0.60);
		
		int endy= (int)(size.getHeight()*0.10);
		
		driver.swipe(x, starty, x, endy, 2000);
		*/
		service.stop();
	}

}
