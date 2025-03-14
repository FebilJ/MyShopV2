package com.MyshopV2.pageObjects;

import com.MyshopV2.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPaymentPage extends CommonToAllPage{

					//Object of Webdriver
					WebDriver driver;
					
					//Constructor
				    public OrderPaymentPage(WebDriver driver){
				        this.driver = driver;
				    }
				    
					//Step 1 - Page Locators
				    private By payByBankWire = By.xpath("//a[@title='Pay by bank wire']");
				    private By payByCheque = By.xpath("//a[@title='Pay by check.']");
					
					//Page Actions
					public void clickOnPayByBankWire(){
				 		clickElement(payByBankWire);
					}
					
					 public void clickOnPayByCheque(){
						 		clickElement(payByCheque);
					}
}
