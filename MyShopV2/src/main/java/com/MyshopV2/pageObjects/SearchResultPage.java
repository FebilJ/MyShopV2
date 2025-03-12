package com.MyshopV2.pageObjects;

import com.MyshopV2.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends CommonToAllPage{

					//Object of Webdriver
					WebDriver driver;
					
					//Constructor
				    public SearchResultPage(WebDriver driver){
				        this.driver = driver;
				    }
				    
					//Step 1 - Page Locators
					private By searchResultProduct = By.xpath("//a[@title='Faded Short Sleeve T-shirts'][normalize-space()='Faded Short Sleeve T-shirts']");
					private By more = By.xpath("//span[normalize-space()='More']");
					
					//Page Actions
					 public String getSearchResultProductName() {
						 	String text = getText(searchResultProduct);
					 		return text;
					 }
					 
					 public void clickOnMore() {
						 	clickElement(more);
					 }
}
