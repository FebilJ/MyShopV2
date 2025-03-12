package com.MyShopV2.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.MyShopV2.base.CommonToAllTest;
import com.MyshopV2.drivers.DriverManager;
import com.MyshopV2.pageObjects.IndexPage;
import com.MyshopV2.pageObjects.SearchResultPage;
import com.MyshopV2.pageObjects.myAccount;
import com.MyshopV2.pageObjects.registeredUserAccount;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TC_ProductPagesTest extends CommonToAllTest{
		
	private static final Logger logger = LogManager.getLogger(TC_ProductPagesTest.class);
	
				@Test(enabled=true)
				public void VerifySearchProduct() throws IOException
				{
							String searchKey = "T-shirts";
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
							
							//Enter product to search in search box
							registeredUserAccount registeredUserAccountObj = new registeredUserAccount(driver);
							registeredUserAccountObj.EnterDataInSearchBox(searchKey);
							registeredUserAccountObj.ClickOnSearchButton();
							
							// Get Name of Searched Product
							SearchResultPage resultPg = new SearchResultPage(driver);
							String SearchResultProductname=resultPg.getSearchResultProductName();
							
							//Verify that correct Product is displaying after search
							if(SearchResultProductname.contains(searchKey))
							{
								logger.info("Search Product testcase - Passed"); 
								Assert.assertTrue(true);
								registeredUserAccountObj.clickOnSignOut();
							}
							else
							{
								logger.info("Search Product testcase - Failed");
								captureScreenShot(driver,"VerifySearchProduct");
								Assert.assertTrue(false);
							}
							logger.info("***************TestCase Search Product ends*****************"); 
						}
}