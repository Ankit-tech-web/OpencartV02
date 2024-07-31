package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	
	@Test(groups= {"Regression","Master"})
	public void verify_account_registration()
	{	
		try
		{
		
	logger.info("****Starting testcase****");
	HomePage hp=new HomePage(driver);
	hp.clickMyAccount();
	
	logger.info("****clicking myaccount****");
	hp.clickRegister();
	logger.info("****clicking on register****");
	AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
	logger.info("****providing customer details****");
	
	regpage.setFirstName(randomeString().toUpperCase());
	regpage.setLastName(randomeString().toUpperCase());
	
	regpage.setEmail(randomeString()+"@gmail.com");
	
	
	regpage.setTelephone(randomeNumber());
	
	String password=randomeAlphaNumeric();
	
	regpage.setPassword(password);
	regpage.setConfirmPassword(password);
	
	
	regpage.setPrivacyPolicy();
	regpage.clickContinue();
	
	logger.info("****validating expected message****");
	String confmsg=regpage.getConfirmationMsg();
	if(confmsg.equals("Your Account Has Been Created!"))
	{
		Assert.assertTrue(true);
	}
	else
	{
		logger.error("Test Failed ");
		logger.debug("Debug logs");
		Assert.assertTrue(false);
	}
	
	//Assert.assertEquals(confmsg, "Your Account Has Been Created!!!");
		}catch(Exception e)
		{
			
			Assert.fail();
		}
		logger.info("****ending testcase****");
	}
	
	
}
