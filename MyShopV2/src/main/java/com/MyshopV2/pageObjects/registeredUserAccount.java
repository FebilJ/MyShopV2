package com.MyshopV2.pageObjects;

import com.MyshopV2.base.CommonToAllPage;
import com.MyshopV2.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class registeredUserAccount extends CommonToAllPage{

					//Object of Webdriver
					WebDriver driver;
					
					//Constructor
				    public registeredUserAccount(WebDriver driver){
				        this.driver = driver;
				    }
				    
					//Step 1 - Page Locators
					private By createEmailID = By.xpath("//a[@class='account']");
					
					//Page Actions
					 public String getUserName() {
						 		String text = getText(createEmailID);
						 		return text;
				}
					 
}