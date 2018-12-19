package com.pagelibrary.com.ranfordBank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Generic {
	public static Select dropdownHandle(WebElement e)
	{
		Select s = new Select(e);
		return s;
	}

}
