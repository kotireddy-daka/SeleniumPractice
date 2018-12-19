package com.pagelibrary.com.ranfordBank;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Library;
import Utility.Validate;
import testBase.Base;

public class TestCaseRepository extends Base {
	
	public ExtentReports report;
	public ExtentTest extent;
	
	@BeforeSuite
	public void extentReport()
	{
		//Need to check with Sir
		//report = new ExtentReports(".\\ExtentReport\\report.html",true);
		report = new ExtentReports(getConfPropValue("ReportPath"),true);
	}
	
	@BeforeMethod
	public void sendfunToReport(Method method)
	{
		extent = report.startTest(this.getClass().getSimpleName()+"::"+method.getName());
		extent.assignAuthor("Jai Ganesh");
		extent.assignCategory("Regression Testing...");
	}
	
	
	public void launch()
	{
		System.setProperty(getConfPropValue("ChromeDriverName"),getConfPropValue("ChromeDriverPath"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get(getConfPropValue("Build1"));
		driver.get(getConfPropValue("Build2"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String actValue = driver.getCurrentUrl();
		//String expValue = getConfPropValue("Build1");
		String expValue = getConfPropValue("Build2");
		
		if (actValue.equals(expValue))
		{
			extent.log(LogStatus.PASS,"Expected Value : "+expValue+" is matching with Actual Value : "+actValue);
			extent.log(LogStatus.INFO, "Home Page has launched successfully");
		}
		else
		{
			extent.log(LogStatus.FAIL,"Expected Value : "+expValue+" is not matching with Actual Value : "+actValue);
			extent.log(LogStatus.INFO, "Home Page has not launched successfully");
		}
	}
	public void login()
	{
		LoginPage.usernameTextBox().sendKeys(getConfPropValue("UserName"));
		LoginPage.passwordTextBox().sendKeys(getConfPropValue("Password"));
		LoginPage.loginLink().click();
		
		String actValue = driver.getTitle();
		String expValue = getConfPropValue("ExpLoginPageTitle");
		
		if (actValue.equals(expValue))
		{
			extent.log(LogStatus.PASS,"Expected Value : "+expValue+" is matching with Actual Value : "+actValue);
			extent.log(LogStatus.INFO, "Webpage has navigated");
		}
		else
		{
			extent.log(LogStatus.FAIL,"Expected Value : "+expValue+" is not matching with Actual Value : "+actValue);
			extent.log(LogStatus.INFO, "Webpage has not navigated ");
		}
		
	}
	
	public void launchAdminPage()
	{
		AdminPage.BranchesButton().click();
		
		String actValue = driver.getTitle();
		String expValue = getConfPropValue("ExpAdminPageTitle");
		
		if (actValue.equals(expValue))
		{
			extent.log(LogStatus.PASS,"Expected Value : "+expValue+" is matching with Actual Value : "+actValue);
			extent.log(LogStatus.INFO, "Webpage has navigated");
		}
		else
		{
			extent.log(LogStatus.FAIL,"Expected Value : "+expValue+" is not matching with Actual Value : "+actValue);
			extent.log(LogStatus.INFO, "Webpage has not navigated ");
		}
	}
	
	public void branchSearch()
	{
		Select adminSelect;
		
		adminSelect = Generic.dropdownHandle(AdminPage.countrySelectBox());
		adminSelect.selectByVisibleText(getConfPropValue("Country"));
		
		//Select State
		
		
		adminSelect = Generic.dropdownHandle(AdminPage.stateSelectBox());
		adminSelect.selectByVisibleText(getConfPropValue("State"));
		
		//Select City
		
		adminSelect = Generic.dropdownHandle(AdminPage.citySelectBox());
		adminSelect.selectByVisibleText(getConfPropValue("City"));
		
		AdminPage.bankSearchButton().click();
		
		//Actual Value?
		//Exp Value?
	}
	

	public String newBranchCreation(String[] str)
	{
		Select newBranchSelect;
		NewBranchCreationPage.newBranchButton().click();
		/*NewBranchCreationPage.branchNameTextBox().sendKeys(getConfPropValue(str[0]));
		NewBranchCreationPage.address1TextBox().sendKeys(getConfPropValue(str[1]));
		// NewBranchCreationPage.address2TextBox().sendKeys(getConfPropValue("NewBranchAddress2"));
		// NewBranchCreationPage.address3TextBox().sendKeys(getConfPropValue("NewBranchAddress3"));
		NewBranchCreationPage.areaTextBox().sendKeys(getConfPropValue(str[2]));
		NewBranchCreationPage.zipCodeTextBox().sendKeys(getConfPropValue(str[3]));
				
		newBranchSelect = Generic.dropdownHandle(NewBranchCreationPage.countrySelectBox());
		newBranchSelect.selectByVisibleText(getConfPropValue(str[4]));
		
		newBranchSelect = Generic.dropdownHandle(NewBranchCreationPage.stateSelectBox());
		newBranchSelect.selectByVisibleText(getConfPropValue(str[5]));
		
		newBranchSelect = Generic.dropdownHandle(NewBranchCreationPage.citySelectBox());
		newBranchSelect.selectByVisibleText(getConfPropValue(str[6]));*/
		
		NewBranchCreationPage.branchNameTextBox().sendKeys(str[0]);
		NewBranchCreationPage.address1TextBox().sendKeys(str[1]);
		// NewBranchCreationPage.address2TextBox().sendKeys(getConfPropValue("NewBranchAddress2"));
		// NewBranchCreationPage.address3TextBox().sendKeys(getConfPropValue("NewBranchAddress3"));
		NewBranchCreationPage.areaTextBox().sendKeys(str[2]);
		NewBranchCreationPage.zipCodeTextBox().sendKeys(str[3]);
				
		newBranchSelect = Generic.dropdownHandle(NewBranchCreationPage.countrySelectBox());
		newBranchSelect.selectByVisibleText(str[4]);
		
		newBranchSelect = Generic.dropdownHandle(NewBranchCreationPage.stateSelectBox());
		newBranchSelect.selectByVisibleText(str[5]);
		
		newBranchSelect = Generic.dropdownHandle(NewBranchCreationPage.citySelectBox());
		newBranchSelect.selectByVisibleText(str[6]);
		
		NewBranchCreationPage.submitButton().click();
			
		String actValue = driver.switchTo().alert().getText();
		String expValue = getConfPropValue("ExpNewBranch");
		
		if (actValue.contains(expValue))
		{
			driver.switchTo().alert().accept();
			extent.log(LogStatus.PASS,"Expected Value :"+expValue+"is matching with Actual Value : "+actValue);
			extent.log(LogStatus.INFO, actValue);
		}
		else
		{
			Library.screenshort("xyz");
			driver.switchTo().alert().accept();
			extent.log(LogStatus.FAIL,"Expected Value : "+expValue+" is not matching with Actual Value : "+actValue);
			extent.log(LogStatus.INFO, actValue);			
		}
		
		return actValue;
	}
	
	@AfterSuite
	public void savereport()
	{
		report.flush();
		
	}
	
}
