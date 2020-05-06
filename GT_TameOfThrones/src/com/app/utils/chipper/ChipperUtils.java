package com.app.utils.chipper;

public class ChipperUtils 
{
	public static String decodedString(String actual,int chipperKey)
	{
	    char[] charArr  = actual.toCharArray();
		int decodedChar;
		for(int i=0;i<charArr.length;i++)
		{
			decodedChar = actual.charAt(i)-chipperKey;
			if(decodedChar <'a')
			{
				decodedChar = 'z'+((decodedChar-'a')+1);
			}	
			charArr[i]=(char) decodedChar;
		}
		return String.valueOf(charArr);
	}
	
	
}
