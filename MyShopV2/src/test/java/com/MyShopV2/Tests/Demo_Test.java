package com.MyShopV2.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.MyShopV2.base.CommonToAllTest;
import com.MyshopV2.drivers.DriverManager;
import com.MyshopV2.pageObjects.AddMyFirstAddress;
import com.MyshopV2.pageObjects.IndexPage;
import com.MyshopV2.pageObjects.ProductPage;
import com.MyshopV2.pageObjects.SearchResultPage;
import com.MyshopV2.pageObjects.myAccount;
import com.MyshopV2.pageObjects.registeredUserAccount;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Demo_Test extends CommonToAllTest{
		
	private static final Logger logger = LogManager.getLogger(Demo_Test.class);
	
				@Test(enabled=true)
				public void AddFirstAddress() throws IOException
				{
							//String searchKey = "T-shirts";
							logger.info("\n***************TestCase Search Product started*****************"); 
					
							//Sign in 
							IndexPage IndexPageObj = new IndexPage(DriverManager.getDriver());
							IndexPageObj.launchURL();
					
							//Enter account details- email and password
							myAccount myAccountObj  = new myAccount(DriverManager.getDriver());
							
							logger.info("User Email and Password entered.");
							myAccountObj.enterRegisteredEmailAddress("automate@gmail.com");
							myAccountObj.enterRegisteredPwd("cs1234");
							
							logger.info("Sign In link clicked");
							myAccountObj.Submit();
							
							AddMyFirstAddress AddMyFirstAddressobj = new AddMyFirstAddress(DriverManager.getDriver());
							AddMyFirstAddressobj.clickOnMyFirstAddressPage();
							
							AddMyFirstAddressobj.enterAddrees("1234 Demo Lane, SC 12345, United States");
							AddMyFirstAddressobj.enterCity("New York");
							AddMyFirstAddressobj.enterState("California");//not
							AddMyFirstAddressobj.enterPostalCode("12345");//not
							AddMyFirstAddressobj.enterCountry("United States");
							AddMyFirstAddressobj.enterHomePhone("9845678524");//not
						}
				
				@Test
				public void verifySearchProduct() throws IOException
				{
							String searchKey = "Blouse";
							logger.info("\n***************TestCase Search Product started*****************"); 
					
							//Sign in 
							IndexPage IndexPageObj = new IndexPage(DriverManager.getDriver());
							IndexPageObj.launchURL();
					
							//Enter account details- email and password
							myAccount myAccountObj  = new myAccount(DriverManager.getDriver());
							
							logger.info("User Email and Password entered.");
							myAccountObj.enterRegisteredEmailAddress("automate@gmail.com");
							myAccountObj.enterRegisteredPwd("cs1234");
							
							logger.info("Sign In link clicked");
							myAccountObj.Submit();
							
							registeredUserAccount registeredUserAccountObj = new registeredUserAccount(driver);
							registeredUserAccountObj.EnterDataInSearchBox(searchKey);
							registeredUserAccountObj.ClickOnSearchButton();
							
							ProductPage ProductPageobj = new ProductPage(DriverManager.getDriver());
							ProductPageobj.moreButton();
							ProductPageobj.setColor();
							ProductPageobj.setQuantity("2");
							ProductPageobj.setSize("M");
							ProductPageobj.clickOnAddToCart();
							ProductPageobj.clickOnProceedToCheckOut();
						}
}