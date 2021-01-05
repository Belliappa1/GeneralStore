package com.app.android.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import com.app.androidapp.init.Constants;

public class ExcelLibrary {
	
	public String getDataFromExcel(String sheetName, int row, int cel)
	{
		try
		{
			FileInputStream file=new FileInputStream(new File(Constants.DCfile));
			String data=WorkbookFactory.create(file).getSheet(sheetName).getRow(row).getCell(cel).toString();
			return data;
		}
		catch(Exception e)
		{
			return "";
		}
		
	}
	
	public void writeDataToExcel(String sheetName,int row, int cel, String value) 
	{
		try
		{
		FileInputStream file=new FileInputStream(new File(Constants.DCfile));
		Workbook wb= WorkbookFactory.create(file);
		Sheet sh=wb.getSheet(sheetName);
		sh.createRow(row).createCell(cel).setCellValue(value);
		
		FileOutputStream fos=new FileOutputStream(Constants.DCfile);
		wb.write(fos);
		}
		catch(Exception e)
		{
			
		}
	}
		}
