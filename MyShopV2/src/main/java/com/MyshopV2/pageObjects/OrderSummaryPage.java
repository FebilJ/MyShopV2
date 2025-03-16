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
					private By proceedToCheckout = By.linkText("Proceed to checkout");
					
					//Page Actions
					 public void clickOnProceedtoCheckout() {
						 		clickElement(proceedToCheckout);
					 }
}
