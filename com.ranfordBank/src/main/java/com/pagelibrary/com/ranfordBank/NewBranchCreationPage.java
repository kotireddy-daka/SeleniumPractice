package com.pagelibrary.com.ranfordBank;

import org.openqa.selenium.WebElement;

import testBase.Base;

public class NewBranchCreationPage extends Base {
	static WebElement pageElm;
	
	public static WebElement newBranchButton()
	{
		pageElm = driver.findElement(getElement("NewBranch"));
		return pageElm; 
	}
	
	public static WebElement branchNameTextBox()
	{
		pageElm = driver.findElement(getElement("BranchName"));
		return pageElm;
	}
	
	public static WebElement address1TextBox()
	{
		pageElm = driver.findElement(getElement("Address1"));
		return pageElm;
	}
	
	public static WebElement address2TextBox()
	{
		pageElm = driver.findElement(getElement("Address2"));
		return pageElm;
	}
	
	public static WebElement address3TextBox()
	{
		pageElm = driver.findElement(getElement("Address3"));
		return pageElm;
	}
	
	public static WebElement areaTextBox()
	{
		pageElm = driver.findElement(getElement("Area"));
		return pageElm;
	}
	
	public static WebElement zipCodeTextBox()
	{
		pageElm = driver.findElement(getElement("ZipCode"));
		return pageElm;
	}
	
	public static WebElement countrySelectBox()
	{
		pageElm = driver.findElement(getElement("Country"));
		return pageElm;
	}
	
	public static WebElement stateSelectBox()
	{
		pageElm = driver.findElement(getElement("State"));
		return pageElm;
	}
	
	public static WebElement citySelectBox()
	{
		pageElm = driver.findElement(getElement("City"));
		return pageElm;
	}
	
	public static WebElement submitButton()
	{
		pageElm = driver.findElement(getElement("Submit"));
		return pageElm;
	}
	
}
