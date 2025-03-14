package com.MyshopV2.pageObjects;

import com.MyshopV2.base.CommonToAllPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProductPage extends CommonToAllPage{

					//Object of Webdriver
					WebDriver driver;
					
					//Declaring WebDriver Wait
					WebDriverWait wait;
					
					//Constructor
				    public ProductPage(WebDriver driver){
				        this.driver = driver;
						//Initializing wait 
				        wait = getWait(driver);
				        PageFactory.initElements(driver, this); 
				    }
				    
					//Step 1 - Page Locators
					private By more = By.xpath("//span[normalize-space()='More']");
					private By hoverElement = By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]");
					private By quantitywanted = By.id("quantity_wanted");
					private By size = By.id("group_1");
					private By whitecolor = By.id("color_8");
					private By addToCart = By.name("Submit");
					private By proceedToCheckout = By.xpath("//span[normalize-space()='Proceed to checkout']");
					
					//approach 4
					public void moreButton(){
				        // Perform hover action
				        Actions actions = new Actions(driver);
				        actions.moveToElement(driver.findElement(hoverElement)).perform(); // Hover over the element

				        // Now click the "More" button
				        clickElement(more);
				        custom_wait2();
				    }
					
					public void setColor(){
					 	clickElement(whitecolor);
					}
					 
					 public void setQuantity(String qty){
							 WebElement quantityElement = wait.until(ExpectedConditions.elementToBeClickable(quantitywanted));
							 quantityElement.clear(); // Clear the input field
							 enterInput(quantityElement, qty); // Set a new quantity
					 }
					 
					 public void setSize(String sizeType){
						 	Select obj = new Select(driver.findElement(size));
						 	obj.selectByVisibleText(sizeType);
					 }
					 
					 public void clickOnAddToCart() {
						 	clickElement(addToCart);
					 }
					 
					 public void clickOnProceedToCheckOut(){
							 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
							 WebElement checkOut = wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckout)));
							 clickElement(checkOut);
					 }
}
