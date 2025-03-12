package com.MyshopV2.pageObjects;

import com.MyshopV2.base.CommonToAllPage;
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
					private By userName = By.xpath("//a[@class='account']");
					private By signOut = By.linkText("Sign out");
					private By searchBox = By.id("search_query_top");
					private By submitSearch = By.name("submit_search");
					
					//Page Actions
					 public String getUserName() {
						 		String text = getText(userName);
						 		return text;
					 }
					 
					 public void clickOnSignOut() {
					 		clickElement(signOut);
					 }
					 
					 public void EnterDataInSearchBox(String searchKey) {
					 		enterInput(searchBox, searchKey);
					 }
					 
					 public void ClickOnSearchButton() {
					 		clickElement(submitSearch);
					 }
}
