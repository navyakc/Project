package com.crm.autodesk.GenericUtility;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	
	public int getRandomNum()
	{
		Random ran=new Random();
		int randomNum=ran.nextInt(1000);
		return randomNum;
	}
	
	public void getCurrentDate()
	{
		Date d=new Date();
		
	}

}
