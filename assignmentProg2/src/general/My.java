package general;

import java.util.InputMismatchException;
import java.util.Scanner;

public class My 
{
	static Scanner key = new Scanner(System.in);
	
	public static int getOpt(int min, int max)
	{
		int num=0;
		boolean ok;
			
		do
		{
			try
			{
				ok=true;
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
	
	public static char getYN()
	{
		String s;
		char ch;
		
		do
		{
			System.out.print("\n\tPlease enter Y or No");
			s=key.next();
			ch=s.toUpperCase().charAt(0);
		} while(ch!='Y' && ch!='N');
		
		return ch;
	}
}