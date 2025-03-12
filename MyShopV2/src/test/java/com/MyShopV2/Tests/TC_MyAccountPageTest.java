package com.MyShopV2.Tests;

import org.testng.Assert;
import org.testng.annotations.*;

import com.MyShopV2.base.CommonToAllTest;
import com.MyshopV2.drivers.DriverManager;
import com.MyshopV2.pageObjects.AccountCreationDetails;
import com.MyshopV2.pageObjects.AddMyFirstAddress;
import com.MyshopV2.pageObjects.IndexPage;
import com.MyshopV2.pageObjects.myAccount;
import com.MyshopV2.pageObjects.registeredUserAccount;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TC_MyAccountPageTest extends CommonToAllTest{
	
	private static final Logger logger = LogManager.getLogger(TC_MyAccountPageTest.class);
			
			
			@Test(enabled=false)
		    public void verifyRegistrationAndLogin() {
		    		
		    		//logger.info("***************TestCase Verify Registration and Login starts*****************");
		    	
					IndexPage IndexPageObj = new IndexPage(DriverManager.getDriver());
					IndexPageObj.launchURL();
			        
					myAccount myAccountObj  = new myAccount(DriverManager.getDriver());
					myAccountObj.enterCreateEmailAddress("automate2@gmail.com");
					
					AccountCreationDetails AccountCreationDetailsObj = new AccountCreationDetails(DriverManager.getDriver());
					
					AccountCreationDetailsObj.selectTitleMr();
					AccountCreationDetailsObj.enterCustomerFirstName("Jake");
					AccountCreationDetailsObj.enterCustomerLastName("Adam");
					AccountCreationDetailsObj.enterPassword("cs1234@2");
					AccountCreationDetailsObj.register();

					registeredUserAccount registeredUserAccountObj = new registeredUserAccount(DriverManager.getDriver());
					String userName = registeredUserAccountObj.getUserName();
					
			        assertThat(userName).isNotBlank().isNotNull().isNotEmpty();
			        Assert.assertEquals("Jake Adam",userName);
		    }
			
			@Test
			public void VerifyLogin() throws IOException {
				
				IndexPage IndexPageObj = new IndexPage(DriverManager.getDriver());
				IndexPageObj.launchURL();
		        
				myAccount myAccountObj  = new myAccount(DriverManager.getDriver());
				
				myAccountObj.enterRegisteredEmailAddress("automate@gmail.com");
				myAccountObj.enterRegisteredPwd("cs1234");
				myAccountObj.Submit();
				
				registeredUserAccount registeredUserAccountObj = new registeredUserAccount(DriverManager.getDriver());
				String userName = registeredUserAccountObj.getUserName();
				
				assertThat(userName).isNotBlank().isNotNull().isNotEmpty();
		        Assert.assertEquals("Jake adam",userName);
		        
		        if(userName.equals("Jake adam"))
				{
					logger.info("VerifyLogin - Passed");
					Assert.assertTrue(true);
				}
				else
				{
					logger.info("VerifyLogin - Failed");
					captureScreenShot(driver,"VerifyLogin");
					Assert.assertTrue(false);
				}
				logger.info("***************TestCase Verify Login ends*****************"); 
			}
			
			@Test
			public void verifyAddNewAddress() throws IOException {
			
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
				AddMyFirstAddressobj.enterState("California");
				AddMyFirstAddressobj.enterPostalCode("12345");
				AddMyFirstAddressobj.enterCountry("United States");
				AddMyFirstAddressobj.enterHomePhone("9845678524");
				AddMyFirstAddressobj.submitSave();
			}
}