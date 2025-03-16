package com.MyshopV2.pageObjects;

import com.MyshopV2.base.CommonToAllPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
						WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
						 WebElement bankWireCheckOut = wait.until(ExpectedConditions.elementToBeClickable(payByBankWire));
						 clickElement(bankWireCheckOut);
					}
					
					 public void clickOnPayByCheque(){
						 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
						 WebElement bankCheckOut = wait.until(ExpectedConditions.elementToBeClickable(payByCheque));
						 clickElement(bankCheckOut);
					}
}
