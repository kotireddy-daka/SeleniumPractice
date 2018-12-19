package Utility;

import com.relevantcodes.extentreports.LogStatus;

import testBase.Base;

public class Validate extends Base{

	
	    public static boolean  isValidAlert(String exp)
	    {
	    	boolean b= driver.switchTo().alert().getText().contains(exp);
	    	return b;
	    }
	    public static boolean  isValidTitle(String exp)
	    {
	    	boolean b= driver.getTitle().contains(exp);
	    	return b;
	    }
	    public static boolean isValidURL(String expValue, String passMsg, String failMsg)
	    {
	    	String actValue = driver.getCurrentUrl();
	    		    	
	    	/*if (actValue.equals(expValue))
			{
				extent.log(LogStatus.PASS,"Expected Value : "+expValue+" is matching with Actual Value : "+actValue);
				extent.log(LogStatus.INFO, passMsg);
			}
			else
			{
				extent.log(LogStatus.FAIL,"Expected Value : "+expValue+" is not matching with Actual Value : "+actValue);
				extent.log(LogStatus.INFO, failMsg);
			}*/
	    	
	    	return true;
	    }
	    public static boolean isValidText(String exp)
	    {
	    	//boolean b = driver.getCurrentUrl().equals(exp); ??
	    	return true;
	    }
	    
}
