package scenarios;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pageObjects_General.PopUpAllow;
import pageObjects_General.Scrolling;
import pageObjects_Old.DiagnosePlant;
import pageObjects_Old.PlantDisease;
import resources.base;

//mandatory importer
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.offset.ElementOption.element;


public class FarmDoctorOld extends base {

	@Test
	public void scenarioSecondApp() throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		service = startServer();

		AndroidDriver<AndroidElement> driver = capabilities("FarmAppOld");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		DiagnosePlant old_diag=new DiagnosePlant(driver);
		old_diag.diagnosePlant.click();
		old_diag.optionKamera.click();
		
		PopUpAllow popup=new PopUpAllow(driver);
		popup.popUpAllow.click();
		Thread.sleep(5000);
		
		//Invisible popUp
		/*String toast=driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		System.out.println(toast);
		Thread.sleep(5000);
		*/
		
		//TouchAction
		TouchAction touch=new TouchAction(driver);
		//Tap or Press Actions
		WebElement infoIcon=driver.findElement(By.id("com.android.plantdiseasesdetection:id/action_info"));
		WebElement flashIcon=driver.findElement(By.xpath("//android.widget.Switch"));
	    touch.tap(tapOptions().withElement(element(flashIcon))).perform();
	    Thread.sleep(5000);
	    
	    //Press Actions
	    touch.longPress(longPressOptions().withElement(element(infoIcon)).withDuration(ofSeconds(2))).release().perform();
	    Thread.sleep(5000);
	    
	    driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		old_diag.diagnosePlant.click();
		old_diag.optionGambar.click();
		old_diag.backIcon.click();
		
		PlantDisease old_pd=new PlantDisease(driver);
		old_pd.moreOption.click();
		Thread.sleep(5000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		old_pd.plantDisease.click();
		
		//using textContains if long text
		Scrolling scroll=new Scrolling(driver);
		scroll.scrollToText("Pepper Bacterial");
		
		//prop.getProperty("oldsearchplant")
		driver.findElement(MobileBy.AndroidUIAutomator("textContains(\""+prop.getProperty("oldsearchplant")+"\")")).click();
		
		//Scroll Down
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));

		//Scroll Up
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollBackward()"));
		
		//WebElement clickPlant= driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.android.plantdiseasesdetection:id/rv_list_diseases\")).scrollIntoView(new UiSelector().textContains(\"Corn Healthy\").instance(0))"));
		//clickPlant.click();
		/*int count = driver.findElements(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView")).size();

		System.out.println("FrameLayout "+count);

		for (int i = 0; i < count; i++)

		{

			String text = driver.findElements(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView")).get(i).getText();

			if (text.equalsIgnoreCase("Corn Healthy"))

			{

				driver.findElements(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView")).get(i).click();

				break;

			}

		}
		*/
		Thread.sleep(5000);
	}
	
	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException
	{
	//taskkill /F /IM node.exe
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
		
	}
}
