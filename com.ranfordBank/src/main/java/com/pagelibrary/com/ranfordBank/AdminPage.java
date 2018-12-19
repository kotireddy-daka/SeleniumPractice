package com.pagelibrary.com.ranfordBank;

import org.openqa.selenium.WebElement;

import testBase.Base;

public class AdminPage extends Base{
	
	static WebElement pageElm;
	
	public static WebElement BranchesButton()
	{
		pageElm = driver.findElement(getElement("Branches"));
		return pageElm;
	}
	public static WebElement countrySelectBox()
	{
		pageElm = driver.findElement(getElement("SearchCountry"));
		return pageElm; 
	}
	
	public static WebElement stateSelectBox()
	{
		pageElm = driver.findElement(getElement("SearchState"));
		return pageElm;
	}
	
	public static WebElement citySelectBox()
	{
		pageElm = driver.findElement(getElement("SearchCity"));
		return pageElm;
	}
	
	public static WebElement bankSearchButton()
	{
		pageElm = driver.findElement(getElement("Search"));
		return pageElm;
	}
	
	
	
	

}
