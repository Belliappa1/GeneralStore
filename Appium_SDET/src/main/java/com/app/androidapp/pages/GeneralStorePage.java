package com.app.androidapp.pages;

import org.openqa.selenium.support.PageFactory;

import com.app.androidapp.util.MobileActionUtil;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GeneralStorePage {

	private AndroidDriver driver;
	
	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private MobileElement yourNameTab;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private MobileElement letsShopBtn;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Products']")
	private MobileElement titleText;
	
	public GeneralStorePage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
	
	
	
	public void sendData(String value) {
		yourNameTab.sendKeys(value);
		
	}
	public void tapButton() {
		MobileActionUtil.tapOnElement(letsShopBtn, driver);
	}
	
	public String titleText() {
		return titleText.getText();
	}
	
}
	
	
