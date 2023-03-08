/* Author: L Castro
 * Date: 2/25/2023
 * Purpose: Write a program that calculates the day of the week based on a date inputed by a user
 * Assumptions:
 * - The user will enter a date in the following format mm/dd/yyyy
 * - The user will enter a year that falls between 1700 and 2699
 * - The user will enter a month number between 01 and 12
 * - The user will enter a day number between 01 and 31
 * - Use primitve integer data type 
*/

package DayName;

import javax.swing.*;

public class DayName 
{ 
	public static void main(String[] args)
	{
		//Declare and initialize variables listing in alphabetical order
		boolean bIsLeapYear = false; //value to test if iCenturyYear is a leap year
		
		int iCenturyCode = -1,	//value used for final calculation
			iCenturyYear = -1,	//index position 6 to end of sDate
			iDayCode = -1,		//index position 3 and 4 of sDate
			iDay = -1, 			//value is product of final calculation
			iMonthCode = -1,	//value used for final calculation
			iMonth = -1,		//index position 0 and 1 of sDate
			iYearBegin = -1,	//index position 6 and 7 of sDate
			iYear = -1;			//index position 8 and 9 of sDate
		
		String sDate = "",		//user's input
			   sDayOfWeek = ""; //output day of the week based on sDate
			
		//Prompt the user for a date (mm/dd/yyyy)
		sDate = JOptionPane.showInputDialog("Welcome!\nPlease enter a date (use the following format mm/dd/yyyy): ");
		
		//Extract the data needed to make calculations. Use String object methods and convert values to integers.
		iDay = Integer.parseInt(sDate.substring(3,5));
		iMonth = Integer.parseInt(sDate.substring(0,2));
		iCenturyYear = Integer.parseInt(sDate.substring(6));
		iYear = Integer.parseInt(sDate.substring(8));
		iYearBegin = Integer.parseInt(sDate.substring(6,8));
		
		//Determine if iCenturyYear is a leap year using if,else if, else and assign boolean value
		if (iCenturyYear % 4 == 0 && iCenturyYear % 100 != 0)
		{
			bIsLeapYear = true;//is a leap year
		}
		else if (iCenturyYear % 4 == 0 && iCenturyYear % 100 == 0 && iCenturyYear % 400 == 0)
		{
			bIsLeapYear = true;//is a leap year
		}
		else
			bIsLeapYear = false; //is not a leap year
		
		//Determine the iCenturyCode based off first two digits of iCenturyYear
		switch (iYearBegin)
		{
			case 19:
			case 23:
				iCenturyCode = 0;
				break;
			case 18:
			case 22:
			case 26:
				iCenturyCode = 2;
				break;
			case 17:
			case 21:
			case 25:
				iCenturyCode = 4;
				break;
			case 20:
			case 24:
				iCenturyCode = 6;
				break;
		}//end switch
		
		//Determine the iMonthCode based off the iMonth value and consider whether the year is a leap year
		if (iMonth == 1 || iMonth == 10)//is the month January or October
		{
			if (iMonth == 1 && bIsLeapYear == true)
			{
				iMonthCode = 6;//the iMonth code when it's a leap year
			}
			else
				iMonthCode = 0;	
		}
		else if (iMonth == 2 || iMonth == 3 || iMonth == 11)//is the month February, March, or November
		{
			if (iMonth == 2 && bIsLeapYear == true)
			{
				iMonthCode = 2;//the iMonth code when it's a leap year
			}
			else
				iMonthCode = 3;	
		}
		else if (iMonth == 4 || iMonth == 7)//is the month April or July
		{
			iMonthCode = 6;	
		}
		else if (iMonth == 5)//is the month May
		{
			iMonthCode = 1;	
		}
		else if (iMonth == 6)//is the month June
		{
			iMonthCode = 4;	
		}
		else if (iMonth == 8)//is the month August
		{
			iMonthCode = 2;	
		}
		else
			iMonthCode = 5;//any other month
		
		//Perform calculation to determine the code for the day of the week
		iDayCode = (iCenturyCode + iYear + (iYear / 4) + iMonthCode + iDay) % 7;
		
		//Write switch statements to extract the day of the week to the corresponding iDayCode
		switch (iDayCode)
		{
			case 0:
				sDayOfWeek = "Sunday";
				break;
			case 1:
				sDayOfWeek = "Monday";
				break;
			case 2:
				sDayOfWeek = "Tuesday";
				break;
			case 3:
				sDayOfWeek = "Wednesday";
				break;
			case 4:
				sDayOfWeek = "Thursday";
				break;
			case 5:
				sDayOfWeek = "Friday";
				break;
			case 6:
				sDayOfWeek = "Saturday";
				break;
		}
		
		//Output results to the screen
		JOptionPane.showMessageDialog(null,String.format("%-20s", "Date:") + sDate +
										   String.format("%-21s", "\nDay:") + sDayOfWeek, 
									       "Day of the Week Calculator",
									       JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
		
	}//end main method
	
}//end DayName class
