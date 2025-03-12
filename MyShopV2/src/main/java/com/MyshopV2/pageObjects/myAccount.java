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
					
					//Page Locators
					//For new users
					private By createEmailID = By.id("email_create");
					private By SubmitCreate = By.id("SubmitCreate");
					
					//For Already registered users
					private By registeredUsersEmail = By.id("email");
					private By registeredUsersPwd = By.id("passwd");
					private By SubmitLogin = By.id("SubmitLogin");
					
					//Page Actions
					//For Creating new  an account
					 public void enterCreateEmailAddress(String user) {
						 		enterInput(createEmailID, user);
						 		clickElement(SubmitCreate);
							    
				}
					//For login existing users
					 public void enterRegisteredEmailAddress(String user) {
					 		enterInput(registeredUsersEmail, user);
			}
					 public void enterRegisteredPwd(String pwd) {
					 		enterInput(registeredUsersPwd, pwd);
						    custom_wait();
			}
					 public void Submit() {
					 		clickElement(SubmitLogin);
						    custom_wait();
			}
}