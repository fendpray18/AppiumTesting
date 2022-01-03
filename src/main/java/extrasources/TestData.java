package extrasources;

import org.testng.annotations.DataProvider;

public class TestData {

	@DataProvider(name="InputData")
	public Object[][] getDataforEditField()
	{
		//example input 2 times data
		Object[][] obj=new Object[][]
				{
			
			{"potato early blight"}, {"apple scab"}
				};
				
				return obj;
				
	}

}
