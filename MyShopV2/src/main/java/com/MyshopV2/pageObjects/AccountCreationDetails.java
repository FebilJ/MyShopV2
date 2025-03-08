package com.MyshopV2.pageObjects;

import com.MyshopV2.base.CommonToAllPage;
import com.MyshopV2.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class AccountCreationDetails extends CommonToAllPage{

					//Object of Webdriver
					WebDriver driver;
					
					//Constructor
				    public AccountCreationDetails(WebDriver driver){
				        this.driver = driver;
				    }
					
					//Step 1 - Page Locators
					private By titleMr = By.id("id_gender1");
					private By firstname = By.id("customer_firstname");
					private By lastname = By.id("customer_lastname");
					private By password = By.id("passwd");
					private By register = By.id("submitAccount");
//					private WebElement day = driver.findElement(By.id("days"));
//					private WebElement month = driver.findElement(By.id("months"));
//					private WebElement year = driver.findElement(By.id("years"));
					
					//identy acctions to perform
					public void selectTitleMr()
					{
						clickElement(titleMr);
					}

					public void enterCustomerFirstName(String fname)
					{
						enterInput(firstname, fname);
					}

					public void enterCustomerLastName(String lname)
					{
						enterInput(lastname, lname);
					}

					public void enterPassword(String pwd)
					{
						enterInput(password, pwd);
					}
					
					public void register()
					{
						clickElement(register);
					}
					
//					public void selectDay(String text)
//					{
//						Select obj = new Select(day);
//						obj.selectByVisibleText(text);
//					}
					
//					public void selectDay(String text) {
//					    WebElement day = driver.findElement(By.id("days"));
//					    Select obj = new Select(day);
//					    obj.selectByVisibleText(text);
//					}
					
//					public void selectDay(String value) {
//					    WebElement dayDropdown = visibilityOfElement(By.xpath("//option[@value='5']")); // Wait for the dropdown to be visible
//					    Select obj = new Select(dayDropdown);
//					    obj.selectByValue(value); // Use the value attribute directly
//					}
					
//					
//					public void selectMonth(String text)
//					{
//						Select obj = new Select(month);
//						obj.selectByVisibleText(text);
//					}
//					
//					public void selectYear(String text)
//					{
//						Select obj = new Select(year);
//						obj.selectByVisibleText(text);
//					}
}