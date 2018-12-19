package com.pagelibrary.com.ranfordBank;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import testBase.Base;

public class LoginPage extends Base{
	
	public static WebElement usernameTextBox()
	{
		return driver.findElement(getElement("UserName"));
	}
	
	public static WebElement passwordTextBox()
	{
		return driver.findElement(getElement("Password"));
	}
	
	public static WebElement loginLink()
	{
		return driver.findElement(getElement("Login"));
	}

}
