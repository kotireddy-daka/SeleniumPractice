package com.pagelibrary.com.ranfordBank;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import exceldata.ExcelClass;

public class TestExecution extends TestCaseRepository{
	
	@Test(priority=0)
	public void verifyLaunch()
	{
		launch();
	}
	
	@Test(priority=1)
	public void verifyLogin()
	{
		login();
	}
	
	@Test(priority=2)
	public void verifyLaunchAdminPage()
	{
		launchAdminPage();
	}
	@Test(priority=4)
	public void verifyBranchSearch()
	{
		branchSearch();
	}

	@Test(priority=3)
	public void verifyNewBranchCreation()
	{
		ExcelClass.excelConnection("data.xls", "NewBranchDetails");
		ExcelClass.OutputExcelConn("data.xls", "output_data.xls", "NewBranchDetails");
		
		//int c=ExcelClass.columnCount();
		/*for(int r=1;r<ExcelClass.rowCount();r++)
		{
			newBranchCreation(str);
			
			 if(actValue.contains("created success"))
			 {
				 ExcelClass.writeData(c++, r, actValue);
				 c--;
			 }
			 else if(actValue.contains("already Exists"))
			 {
				 ExcelClass.writeData(c++, r, actValue);
				 c--;
			 }
			 else
			 {
				 ExcelClass.writeData(c++, r, "n/a");
				 c--;
			 }
		}
		ExcelClass.saveWorkbook();*/
		
		String str[] = new String[ExcelClass.columnCount()];
		int col2 = 0;
		for (int row=0; row < ExcelClass.rowCount(); row++)
		{
			for (col2=0; col2 < ExcelClass.columnCount(); col2++)
			{
				 str[col2] = ExcelClass.readData(col2, row);
				 System.out.print(str[col2]+" ");
			}
			System.out.println();
			//launchNewBranchCreationPage();
			String staus = newBranchCreation(str);
			ExcelClass.writeData(col2, row, staus);
		}
		ExcelClass.saveWorkbook();
	}
}
