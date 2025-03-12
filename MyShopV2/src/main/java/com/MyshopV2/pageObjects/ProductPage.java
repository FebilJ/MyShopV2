package com.MyshopV2.pageObjects;

import com.MyshopV2.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class ProductPage extends CommonToAllPage{

					//Object of Webdriver
					WebDriver driver;
					
					//Constructor
				    public ProductPage(WebDriver driver){
				        this.driver = driver;
				        PageFactory.initElements(driver, this); 
				    }
				    
					//Step 1 - Page Locators
					private By more = By.xpath("//span[normalize-space()='More']");
					private By hoverElement = By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]");
					private By quantitywanted = By.id("quantity_wanted");
					private By size = By.id("group_1");
					private By whitecolor = By.id("color_8");
					private By addToCart = By.name("Submit");
					private By proceed = By.name("//span[normalize-space()='Proceed to checkout']");
					
					//Page Actions
//					Approach 1
//					public void moreButton(){
//					 	clickElement(more);
//					}
					
					//approach 2
//					public void moreButton() {
//				        // Create an Actions object
//				        Actions actions = new Actions(driver);
//				        
//				        // Hover over the element that triggers the display of the 'More' button
//				        WebElement hoverElement = driver.findElement(By.id("//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line last-line first-item-of-tablet-line first-item-of-mobile-line last-mobile-line']")); // Replace with the actual ID of the hover element
//				        actions.moveToElement(hoverElement).perform();
//
//				        // Now click the 'More' button
//				        clickElement(more);
//				    }
					
					//approach 3
//					 public void hoverAndClickMore() {
//					        Actions actions = new Actions(driver); // Create an Actions object
//					        WebElement moreButton = driver.findElement(more); // Find the "More" button
//					        actions.moveToElement(moreButton).click().perform(); // Hover and click
//					    }
					
					//approach 4
					public void moreButton() {
				        // Perform hover action
				        Actions actions = new Actions(driver);
				        actions.moveToElement(driver.findElement(hoverElement)).perform(); // Hover over the element

				        // Now click the "More" button
				        clickElement(more);
				        custom_wait();
				    }
					
					 public void setQuantity(String qty) {
						 WebElement quantityElement = driver.findElement(quantitywanted);
					      quantityElement.clear();
					      enterInput(quantityElement, qty);
					 }
					 
					 public void setSize(String sizeType) {
						 	Select obj = new Select(driver.findElement(size));
						 	obj.selectByVisibleText(sizeType);
					 }
					 
					 public void setColor() {
						 	clickElement(whitecolor);
					 }
					 
					 public void clickOnAddToCart() {
						 	clickElement(addToCart);
					 }
					 
					 public void clickOnProceedToCheckOut() {
						 	clickElement(proceed);
					 }
}
