package com.MyshopV2.pageObjects;

import com.MyshopV2.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderSummaryPage extends CommonToAllPage{

					//Object of Webdriver
					WebDriver driver;
					
					//Constructor
				    public OrderSummaryPage(WebDriver driver){
				        this.driver = driver;
				    }
				    
					//Step 1 - Page Locators
					private By proceedToCheckout = By.xpath("(//span[normalize-space()='Proceed to checkout'])[2]");
					
					//Page Actions
					 public void clickonProceedtoCheckout() {
						 		clickElement(proceedToCheckout);
					 }
}
