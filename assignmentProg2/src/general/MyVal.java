package general;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyVal
{
	static Scanner key = new Scanner(System.in);
	
	public static int validInt(String msg, int min, int max)
	{
		int num=0;
		boolean ok;
			
		do
		{
			try
			{
				ok=true;
				System.out.print(msg);
				num=key.nextInt();
				key.nextLine();
					
				if(num<min || num>max)
				{
					ok=false;
					System.out.print(String.format("\n\tError: Range is %5d - %5d. Please re-enter. ", min, max));
				}
			}
			catch (InputMismatchException e)
			{
				System.out.print("\n\tError: Illegal character(s) input. Please re-enter. ");
				key.nextLine();
				ok=false;
			}	
		}while(!ok);
			
		return num;
	}
		
	public static int validInt2(String msg)
	{
		int num=0;
		boolean ok;
			
		do
		{
			try
			{
				ok=true;
				System.out.print(msg);
				num=key.nextInt();
				key.nextLine();
					
			}
			catch (InputMismatchException e)
			{
				System.out.print("\n\tError: Illegal character(s) input. Please re-enter. ");
				key.nextLine();
				ok = false;
			}	
		}while(!ok);
			
		return num;
	}
		
		
	public static double validDouble(String msg, double min, double max)
	{
		double num=0;
		boolean ok;
			
		do
		{
			try
			{
				ok=true;
				System.out.print(msg);
				num=key.nextDouble();
				key.nextLine();
					
				if(num<min || num>max)
				{
					ok=false;
					System.out.print(String.format("\n\tError: Range is %5.2f - %5.2f. Please re-enter,", min, max));
				}
			}
			catch (InputMismatchException e)
			{
				System.out.print("\n\tError: Illegal character(s); input. Please re-enter. ");
				key.nextLine();
				ok=false;
			}		
		}while(!ok);
			
		return num;
	}
		
	public static double validDouble2(String msg)
	{
		double num=0;
		boolean ok;
			
		do
		{
			try
			{
				ok=true;
				System.out.print(msg);
				num=key.nextDouble();
				key.nextLine();
					
			}
			catch (InputMismatchException e)
			{
				System.out.print("\n\tError: Illegal character(s); input. Please re-enter. ");
				key.nextLine();
				ok=false;
			}		
		}while(!ok);
			
		return num;
	}
		
	//needs reviewed
	public static char validChar(String msg)
	{
		char c;
		boolean valid;
			
		do
		{
			valid=true;
			System.out.print(msg);
			c=key.next().charAt(0);
			if (c == 'y' || c == 'Y' || c == 'n' || c == 'N')
			{
				valid=true;
			}
			else
			{
				valid=false;
				System.out.println("\n\tError! Must input Y/N");
			}
				
		}while (!valid);
			
		return c;
	}
	
	public static String validString(String msg, int min, int max)
	{
		String s = " ";
		boolean ok=true;
			
		do
		{
			try
			{
				ok=true;
				System.out.print(msg);
				s=key.nextLine();
					
				if(s.length()<min || s.length()>max)
				{
					ok=false;
					System.out.print(String.format("\n\tError: Length of text input range is %5d - %-5d. Please re-enter. ", min, max));
				}
			}
			catch (InputMismatchException e)
			{
				System.out.print("\n\tError: Illegal character(s) input. Please re-enter. ");
				key.nextLine();
				ok=false;
			}	
		}while(!ok);
			
		return s;
	}
}
