package com.MyshopV2.pageObjects;

import com.MyshopV2.base.CommonToAllPage;
import com.MyshopV2.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class myAccount extends CommonToAllPage{

					//Object of Webdriver
					WebDriver driver;
					
					//Constructor
				    public myAccount(WebDriver driver){
				        this.driver = driver;
				    }
					

					//Step 1 - Page Locators
					private By createEmailID = By.id("email_create");
					
					private By SubmitCreate = By.id("SubmitCreate");
					
					//Page Actions
					//Clicking on Create an account 
					 public void enterCreateEmailAddress(String user) {
						 		enterInput(createEmailID, user);
						 		clickElement(SubmitCreate);
							    custom_wait2();
				}
}