package com.MyshopV2.pageObjects;

import com.MyshopV2.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage extends CommonToAllPage{

					//Object of Webdriver
					WebDriver driver;
					
					//Constructor
				    public OrderConfirmationPage(WebDriver driver){
				        this.driver = driver;
				    }
				    
					//Step 1 - Page Locators
				    private By confirmOrder = By.xpath("//span[normalize-space()='I confirm my order']");
				    private By successMessage = By.xpath("//p[normalize-space()='Your order on My Shop is complete.']");
				    private By signOut = By.linkText("Sign out");
				  
					
					//Page Actions
					public void clickOnConfirmOrder(){
				 		clickElement(confirmOrder);
					}
					
					 public String getOrderSuccessMessage(){
						 		return getText(successMessage);
					}
					 
					 public void clickSignOut(){
					 		clickElement(signOut);
						}
}
