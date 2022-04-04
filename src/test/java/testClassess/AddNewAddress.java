package testClassess;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import baseClassess.BaseClass1;
import pomClassess.HomePage;
import pomClassess.LoginPage;
import pomClassess.ProfilePage;
import utilityClassess.UtilityClass;

public class AddNewAddress {


	WebDriver driver;
	LoginPage lp;
	HomePage hp;
	ProfilePage pp;


	ExtentReports reports;
	ExtentTest test;

	//@Parameters("browser")
	@BeforeClass

	public void beforeclass()                //String a  
	{
		reports = new ExtentReports("ExtentReports.html",true);
		test =reports.startTest("AddNewAddress");

		driver = BaseClass1.getWebDriver();     //a
	}


	@BeforeMethod

	public void beforemethod()
	{
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		pp = new ProfilePage(driver);
	}

	@Test

	public void VerifyUserCanLogIn() throws InterruptedException, IOException
	{
		lp.EnterEmailID();
		Reporter.log("User Entered EmailID");
		lp.EnterPassword();
		Reporter.log("User Entered PassWord");
		lp.ClickOnSubmitButton();
		Reporter.log("User Click on Submit Button");
		hp.hoverToProfileName();

		String text = hp.GetLogOutText();

		Assert.assertEquals(text,"Logout");

		test.log(LogStatus.PASS, "LogIn Test Passed");
		
	}

	@DataProvider(name="dataset")
	public String[][] dataToTest()
	{

		String [][] data = {{"Mahesh","9856412589","411041","Pune City"}, {"Suverna","9856415889","413512","Latur City"}};

		return data;

	}

	@Test(priority=1, dataProvider="dataset")

	public void UserCanAddNewAddress(String name,String mobnumber,String pincode,String locality) throws InterruptedException 
	{
       
		hp.MovePointer();
		hp.hoverToProfileName();
		hp.ClickOnMyProfileText();
		pp.ClickOnManageAddress();
		pp.ClickOnAddNewAddress();

		List<String> datalist = new ArrayList<String>();
		datalist.add(name);
		datalist.add(mobnumber);
		datalist.add(pincode);
		datalist.add(locality);


		pp.GetDataForAddress(datalist);
		pp.AdressField();
		pp.ClickOnRadio();
		pp.ClickOnSave();
		Thread.sleep(2000);

		int oldCount= pp.getAddressCount();

		Assert.assertEquals(oldCount, oldCount+2);
	}


	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException, InterruptedException
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(((UtilityClass) pp).screenCapture(driver)),"Taken Screenshot");
		}
	}


	@AfterClass
	public void afterClass()
	{
		reports.endTest(test);
		reports.flush();
		//driver.quit();
	}

}
