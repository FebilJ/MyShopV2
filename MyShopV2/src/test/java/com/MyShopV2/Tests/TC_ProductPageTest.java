package com.MyShopV2.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.MyShopV2.base.CommonToAllTest;
import com.MyshopV2.drivers.DriverManager;
import com.MyshopV2.pageObjects.IndexPage;
import com.MyshopV2.pageObjects.OrderAddressPage;
import com.MyshopV2.pageObjects.OrderConfirmationPage;
import com.MyshopV2.pageObjects.OrderPaymentPage;
import com.MyshopV2.pageObjects.OrderShippingPage;
import com.MyshopV2.pageObjects.OrderSummaryPage;
import com.MyshopV2.pageObjects.ProductPage;
import com.MyshopV2.pageObjects.SearchResultPage;
import com.MyshopV2.pageObjects.myAccount;
import com.MyshopV2.pageObjects.registeredUserAccount;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TC_ProductPageTest extends CommonToAllTest{
		
	private static final Logger logger = LogManager.getLogger(TC_ProductPageTest.class);
	
				@Test
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
								//captureScreenShot(driver,"VerifySearchProduct");
								Assert.assertTrue(false);
							}
							logger.info("***************TestCase Search Product ends*****************"); 
						}
				
				@Test
				public void VerifyBuyProduct() throws IOException
				{
							String searchKey = "Blouse";
							logger.info("\n***************TestCase Buy Product started*****************"); 
					
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
							logger.info("Clicked on search button");
							
							//Product Page
							ProductPage ProductPageObj = new ProductPage(DriverManager.getDriver());
							ProductPageObj.moreButton();
							logger.info("Clicked on more button");
							
							ProductPageObj.setColor();
							logger.info("Clicked on white color");
							
							ProductPageObj.setQuantity("2");
							logger.info("Clicked on Quantity");
							
							ProductPageObj.setSize("M");
							logger.info("Clicked on Size");
							
							ProductPageObj.clickOnAddToCart();
							logger.info("Clicked Add to cart");
							
							ProductPageObj.clickOnProceedToCheckOut();
							logger.info("Clicked Proceed to Checkout");
							
							//Order Summary Page
							OrderSummaryPage OrderSummaryPageObj = new OrderSummaryPage(DriverManager.getDriver());
							OrderSummaryPageObj.clickOnProceedtoCheckout();
							logger.info("Clicked on proceed to checkout on order summary page");

							//Order Address Page
							OrderAddressPage OrderAddressPageObj = new OrderAddressPage(DriverManager.getDriver());
							OrderAddressPageObj.clickOnProceedToCheckout();
							logger.info("Clicked on proceed to checkout on order address page");
							
							//Order Shipping Page
							OrderShippingPage OrderShippingPageObj = new OrderShippingPage(DriverManager.getDriver());
							OrderShippingPageObj.selectTermsOfService();
							logger.info("Selected terms of Service checkbox");
							
							OrderShippingPageObj.clickOnProceedToCheckout();
							logger.info("Clicked on proceed to checkout on order shipping page");
							
							//Order Payment Page
							OrderPaymentPage OrderPaymentPageObj =new OrderPaymentPage(DriverManager.getDriver());
							OrderPaymentPageObj.clickOnPayByCheque();
							logger.info("Clicked on Pay By Cheque");  //time
							
							//Order Confirmation Page
							OrderConfirmationPage OrderConfirmationPageObj = new OrderConfirmationPage(DriverManager.getDriver());
							OrderConfirmationPageObj.clickOnConfirmOrder();
							
							String successMSG = OrderConfirmationPageObj.getOrderSuccessMessage();
							
							if(successMSG.equals("Your order on My Shop is complete."))
							{
								logger.info("VerifyBuyProduct - Passed"); 
								Assert.assertTrue(true);
								OrderConfirmationPageObj.clickSignOut();
							}
							else{
								logger.info("VerifyBuyProduct - Failed");
								//captureScreenShot(driver,"VerifyBuyProduct");
								Assert.assertTrue(false);
							}
							logger.info("***************TestCase Search Product ends*****************"); 
						}
}