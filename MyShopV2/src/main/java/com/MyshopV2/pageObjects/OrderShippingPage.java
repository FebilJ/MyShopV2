package com.MyshopV2.pageObjects;

import com.MyshopV2.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderShippingPage extends CommonToAllPage{

					//Object of Webdriver
					WebDriver driver;
					
					//Constructor
				    public OrderShippingPage(WebDriver driver){
				        this.driver = driver;
				    }
				    
					//Step 1 - Page Locators
				    private By termsOfServices = By.id("cgv"); 
					private By proceedFromAddressPage = By.xpath("(//span[normalize-space()='Proceed to checkout'])[2]");
					
					//Page Actions
					public void selectTermsOfService() {
				 		clickElement(termsOfServices);
			 }
					
					 public void clickOnProceedToCheckout() {
						 		clickElement(proceedFromAddressPage);
					 }
}
