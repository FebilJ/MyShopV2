package com.MyShopV2.Tests;

import org.testng.Assert;
import org.testng.annotations.*;

import com.MyShopV2.base.CommonToAllTest;
import com.MyshopV2.drivers.DriverManager;
import com.MyshopV2.pageObjects.AccountCreationDetails;
import com.MyshopV2.pageObjects.IndexPage;
import com.MyshopV2.pageObjects.myAccount;
import com.MyshopV2.pageObjects.registeredUserAccount;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TC_MyAccountPageTest extends CommonToAllTest{
	
	private static final Logger logger = LogManager.getLogger(TC_MyAccountPageTest.class);
	
			@Test
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

//					AccountCreationDetailsObj.selectMonth("7");
//					AccountCreationDetailsObj.selectYear("2001");
					
//			        logger.info("End of the testLoginNegativeVWO !");
					
					registeredUserAccount registeredUserAccountObj = new registeredUserAccount(DriverManager.getDriver());
					String userName = registeredUserAccountObj.getUserName();
					
			        assertThat(userName).isNotBlank().isNotNull().isNotEmpty();
			        Assert.assertEquals("Jake Adam",userName);
			       
		    }
}