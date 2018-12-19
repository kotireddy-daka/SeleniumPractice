package exceldata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import testBase.Base;

public class ExcelClass extends Base  {
	
	public static String folderPath = getConfPropValue("ExcelPath");
	static Workbook wb;
	static Sheet sh;
	static WritableWorkbook wwb;
	static WritableSheet wsh;
	public static void excelConnection(String fileName, String sheetName)
	{
		
		try {
				File f = new File(folderPath+fileName);
				wb = Workbook.getWorkbook(f);
				sh = wb.getSheet(sheetName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public static int rowCount()
	{
		return sh.getRows();
	}
	
	public static int columnCount()
	{
		return sh.getColumns();
	}
	
	public static String readData(int col, int row)
	{
		Cell c = sh.getCell(col, row);
		return c.getContents();
	}
	
	
	public static void OutputExcelConn(String inFileName, String outFileName, String sheetName)
	{
		try {
			//FileInputStream fis = new FileInputStream(folderPath+inFileName);
			//wb = Workbook.getWorkbook(fis);
			//sh = wb.getSheet(sheetName);
			FileOutputStream fos = new FileOutputStream(folderPath+outFileName);
			wwb = Workbook.createWorkbook(fos, wb); 
			wsh = wwb.getSheet(sheetName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void writeData(int col, int row, String data)
	{
		try {
			Label l = new Label(col, row, data);
			wsh.addCell(l);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void saveWorkbook()
	{
		try {
			wwb.write();
			wwb.close();
			wb.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
