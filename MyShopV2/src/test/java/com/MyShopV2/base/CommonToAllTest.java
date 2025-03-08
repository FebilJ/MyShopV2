package com.MyShopV2.base;

import org.testng.annotations.*;
import com.MyshopV2.drivers.DriverManager;

public class CommonToAllTest {
	
				 @BeforeMethod
			     public void setUp(){
			         DriverManager.init();
			     }
			
//			     @AfterMethod
//			     public void tearDown(){
//			         DriverManager.down();
//			     }
}