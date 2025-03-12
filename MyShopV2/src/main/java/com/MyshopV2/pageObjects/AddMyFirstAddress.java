package com.MyshopV2.pageObjects;

import com.MyshopV2.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddMyFirstAddress extends CommonToAllPage{
					
					//Object of Webdriver
					WebDriver driver;
					
					//Constructor
				    public AddMyFirstAddress(WebDriver driver){
				        this.driver = driver;
				    }
				    
					//Step 1 - Page Locators
					private By addMyFirstAddressPage = By.xpath("//span[normalize-space()='Add my first address']");
					private By address1 = By.id("address1");
					private By city = By.id("city");
					private By state = By.id("id_state");
					private By PostalCode = By.id("postcode");
					private By country = By.id("id_country");
					private By Homephone = By.id("phone");
					private By mobilePhone = By.id("phone_mobile");
					private By assignAddress = By.id("alias");
					private By submitAddress = By.id("submitAddress");
					
					//Page Actions
					 public void clickOnMyFirstAddressPage() {
						 	clickElement(addMyFirstAddressPage);
					 }
					
					public void enterAddrees(String add) {
							enterInput(address1, add);
					}
					
					public void enterCity(String add) {
						enterInput(city, add);
					}
					
					 public void enterState(String text) {
					        Select obj = new Select(driver.findElement(state));
					        obj.selectByVisibleText(text);
					 }
					
					public void enterPostalCode(String add) {
						enterInput(PostalCode, add);
					}
					
				    public void enterCountry(String text) {
				        Select obj = new Select(driver.findElement(country));
				        obj.selectByVisibleText(text);
				    }
					
					public void enterHomePhone(String add) {
						enterInput(Homephone, add);
					}
					
					public void enterMobilePhone(String add) {
						enterInput(mobilePhone, add);
					}
					
					public void enterAlias(String add) {
						enterInput(assignAddress, add);
					}
					
					public void submitSave() {
						clickElement(submitAddress);
					}
}
