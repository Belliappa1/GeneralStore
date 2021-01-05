import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.app.android.lib.BaseLib;
import com.app.android.lib.ExcelLibrary;
import com.app.androidapp.pages.GeneralStorePage;

public class TC_001_GeneralStore extends BaseLib {

	@Test
	public void tc_01_GeneralStore() throws InterruptedException
	{
		GeneralStorePage gsp=new GeneralStorePage(gv.driver);
		ExcelLibrary input=new ExcelLibrary();
		
		WebDriverWait wait =new WebDriverWait(gv.driver, 20); 
		wait.until(ExpectedConditions.visibilityOf(gv.driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"))));
		
		//Step1: Reading data from excel
		gsp.sendData(input.getDataFromExcel("Sheet1", 1, 0));
		System.out.println(input.getDataFromExcel("Sheet1", 1, 0));
		
		//Step2:Tapping on Shopbutton
		gsp.tapButton();
		Thread.sleep(2000);
		
		//Step3: validating the title of the page
		Assert.assertEquals(input.getDataFromExcel("Sheet1", 1, 1), gsp.titleText());
	}
	
}

