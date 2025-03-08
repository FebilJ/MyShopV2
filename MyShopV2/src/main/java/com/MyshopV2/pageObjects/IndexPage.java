package com.MyshopV2.pageObjects;

import com.MyshopV2.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class IndexPage extends CommonToAllPage{

					WebDriver driver;
					
				    public IndexPage(WebDriver driver){
				        this.driver = driver;
				    }
					
					//Page Actions
					//Step 1 - Page Locators
					private By SignInLink = By.className("login");
					
					//opening URL & clicking on signIn Button
					 public void launchURL() {
						 		openMyShopURL();
							     clickElement(SignInLink);
							     custom_wait();
				}
}