package Utility;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;

public class Library {

	
	
	public static void screenshort(String name)
	{
		try {
			Robot r=new Robot();
			
			BufferedImage bi=r.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			
			ImageIO.write(bi, "png", new File(".\\ScreenShots\\"+name+"-"+dateTimeStamp()+".png"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public static String dateTimeStamp()
	{
		Date today = Calendar.getInstance().getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
		String dateTime = formatter.format(today);
		return dateTime;
	}
}
