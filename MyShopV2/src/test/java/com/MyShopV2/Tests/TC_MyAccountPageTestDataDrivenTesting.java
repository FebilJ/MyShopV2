package com.MyShopV2.Tests;

import org.testng.Assert;
import org.testng.annotations.*;

import com.MyShopV2.base.CommonToAllTest;
import com.MyshopV2.drivers.DriverManager;
import com.MyshopV2.pageObjects.AccountCreationDetails;
import com.MyshopV2.pageObjects.IndexPage;
import com.MyshopV2.pageObjects.myAccount;
import com.MyshopV2.pageObjects.registeredUserAccount;
import com.MyshopV2.utils.ReadExcelFile;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TC_MyAccountPageTestDataDrivenTesting extends CommonToAllTest{
	
	private static final Logger logger = LogManager.getLogger(TC_MyAccountPageTestDataDrivenTesting.class);
			
			
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

//					AccountCreationDetailsObj.selectMonth("7");
//					AccountCreationDetailsObj.selectYear("2001");
					
//			        logger.info("End of the testLoginNegativeVWO !");
					
					registeredUserAccount registeredUserAccountObj = new registeredUserAccount(DriverManager.getDriver());
					String userName = registeredUserAccountObj.getUserName();
					
			        assertThat(userName).isNotBlank().isNotNull().isNotEmpty();
			        Assert.assertEquals("Jake Adam",userName);
		    }
			
			@Test(dataProvider = "LoginDataProvider")
			public void VerifyLogin(String userEmail, String userPwd, String expectedUsername) throws IOException {
				
				IndexPage IndexPageObj = new IndexPage(DriverManager.getDriver());
				IndexPageObj.launchURL();
		        
				myAccount myAccountObj  = new myAccount(DriverManager.getDriver());
				
				myAccountObj.enterRegisteredEmailAddress(userEmail);
				myAccountObj.enterRegisteredPwd(userPwd);
				myAccountObj.Submit();
				
				registeredUserAccount registeredUserAccountObj = new registeredUserAccount(DriverManager.getDriver());
				String userName = registeredUserAccountObj.getUserName();
				
//				assertThat(userName).isNotBlank().isNotNull().isNotEmpty();
//		        Assert.assertEquals("Jake adam",userName);
		        
		        if(userName.equals(expectedUsername))
				{
					logger.info("VerifyLogin - Passed");
					Assert.assertTrue(true);
					registeredUserAccountObj.clickOnSignOut();
				}
				else
				{
					logger.info("VerifyLogin - Failed");
					captureScreenShot(driver,"VerifyLogin");
					Assert.assertTrue(false);
				}
				logger.info("***************TestCase Verify Login ends*****************"); 
			}
			
			@DataProvider(name = "LoginDataProvider")
			public String [][] LoginDataProvider(){
				//System.out.println(System.getProperty("user.dir"));
				String fileName = System.getProperty("user.dir") + "\\Test Data\\MyShopTestData.xlsx";

				int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
				int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");

				String data[][]=new String[ttlRows-1][ttlColumns];

				for(int i=1;i<ttlRows;i++)//rows =1,2
				{
					for(int j=0;j<ttlColumns;j++)//col=0, 1,2
					{
						data[i-1][j]=ReadExcelFile.getCellValue(fileName,"LoginTestData", i,j);
					}
				}
				return data;
			}
}