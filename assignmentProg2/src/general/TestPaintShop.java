package general;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import fileAssist.*;
import customers.*;
import java.util.Scanner;

public class TestPaintShop
{
	public static void main(String[] args) throws IOException
	{
		Scanner key = new Scanner(System.in);		
		ArrayList<Customer> quotes = new ArrayList<Customer>();		
		String menuOpts = "\n\t1: Add Customer Quote\n\t2: Display All Quotes\n\t3: Display Quotes by Customer Type\n\t4: Exit\n\n\tEnter Option: ";
		int choice=0;	
		
		populateList(quotes);
			
		do
		{
			System.out.print("\n\n\tPAINT SHOP\n");
			System.out.print(menuOpts);
			choice=My.getOpt(1, 4);
				
			switch(choice)
			{
			case 1:
				addCustomerQuote(quotes);
				break;
			case 2:
				displayAll(quotes);
				break;
			case 3:
				displayQuotesByCustType(quotes);
				break;
			case 4:
				System.out.print("\n\tGoodbye.");
				break;
			}
		} while(choice<4);
	}
	
	public static void populateList(ArrayList<Customer> sales) throws IOException
	{
		try
		{
			List<String> allQuotes=null;
			
			String directory = System.getProperty("user.dir");
			String file = "\\filePaintShopCustomers.txt";
			String fileComplete = directory + file;
			
			allQuotes = Helper.readFileIntoList(fileComplete);
			
			for (int x=0; x<allQuotes.size(); x++)
			{
				String record = allQuotes.get(x);
				String[] allFields = record.split(",");
				
				if(allFields[0].equals("G") && allFields[4].equals("rectangular"))
				{
					General currentGeneral = new General();
					
					currentGeneral.setCustType((allFields[0]).charAt(0));
					currentGeneral.setCustName(allFields[1]); 
					currentGeneral.setCustAdd(allFields[2]);
					currentGeneral.setCustTele(allFields[3]);
					currentGeneral.setRoomShape(allFields[4]);
					currentGeneral.setHeight(Double.parseDouble(allFields[5]));
					currentGeneral.setWidth(Double.parseDouble(allFields[6]));
					currentGeneral.setLength(Double.parseDouble(allFields[7]));
					currentGeneral.setNoDoors(Integer.parseInt(allFields[8]));
					currentGeneral.setNoWindows(Integer.parseInt(allFields[9]));
					
					sales.add(currentGeneral);
				}
				else if (allFields[0].equals("G") && allFields[4].equals("cylindrical"))
				{
					General currentGeneral = new General();
					
					currentGeneral.setCustType((allFields[0]).charAt(0));
					currentGeneral.setCustName(allFields[1]); 
					currentGeneral.setCustAdd(allFields[2]);
					currentGeneral.setCustTele(allFields[3]);
					currentGeneral.setRoomShape(allFields[4]);
					currentGeneral.setHeight(Double.parseDouble(allFields[5]));
					currentGeneral.setWidth(Double.parseDouble(allFields[6]));
					currentGeneral.setNoDoors(Integer.parseInt(allFields[7]));
					currentGeneral.setNoWindows(Integer.parseInt(allFields[8]));
					
					sales.add(currentGeneral);			
				}
				else if (allFields[0].equals("T"))
				{
					Trade currentTrade = new Trade();
					
					currentTrade.setCustType((allFields[0]).charAt(0));
					currentTrade.setTradeName(allFields[1]); 
					currentTrade.setCustAdd(allFields[2]);
					currentTrade.setCustTele(allFields[3]);
					currentTrade.setSurfArea(Double.parseDouble(allFields[4]));
					
					sales.add(currentTrade);	
				}
			}
		}
		catch (MyException e)
		{
			System.out.print(e.toString());
		}
	}
	
	public static void addCustomerQuote(ArrayList<Customer> quotes)
	{
		try
		{
			int choice=0;
	
			choice = MyVal.validInt("\n\n\t1: Add General Customer\n\t2: Add Trade Customer\n\t3: Return\n\n\tEnter Option: ", 1, 3);
	
			switch(choice)
			{
			case 1:
				General newGeneral = new General();
			
				newGeneral.setCustType('G');
				newGeneral.setCustName(MyVal.validString("\n\tPlease enter the customer's name: ", 2, 40));
				newGeneral.setCustAdd(MyVal.validString("\n\tPlease enter the customer's address: ", 5, 40));
				newGeneral.setCustTele(MyVal.validString("\n\tPlease enter the customer's telephone number: ", 10, 11));
				
				if (MyVal.validInt("\n\tPlease enter the room's shape.\n\t1: Rectangular\n\t2: Cylinderical ", 1, 2)==1)
					newGeneral.setRoomShape("rectangular");
				else
					newGeneral.setRoomShape("cylidrical");	
				
				newGeneral.setHeight(MyVal.validDouble("\n\tPlease enter the room's height: ", 1, 100));
				newGeneral.setWidth(MyVal.validDouble("\n\tPlease enter the room's width: ", 1, 100));
				
				if (newGeneral.getRoomShape()=="rectangular")
					newGeneral.setLength(MyVal.validDouble("\n\tPlease enter the room's length: ", 1, 100));
				
				newGeneral.setNoDoors(MyVal.validInt("\n\tPlease enter the number of doors in the room: ", 0, 10));
				newGeneral.setNoWindows(MyVal.validInt("\n\tPlease enter the number of windows in the room: ", 0, 20));
	
				quotes.add(newGeneral);
				System.out.printf("\n\tThe paint coverage is %5.2f.\n\tThe cost of the paint required is %5.2f.", newGeneral.getCoverage(),(Math.ceil(newGeneral.getCoverage())*Constants.tinCost));
				break;
		
			case 2:
				Trade newTrade = new Trade();
			
				newTrade.setCustType('T');	
				newTrade.setTradeName(MyVal.validString("\n\tPlease enter the trade name: ", 2, 40));
				newTrade.setCustAdd(MyVal.validString("\n\tEnter the trade customer's address: ", 5, 40));
				newTrade.setCustTele(MyVal.validString("\n\tEnter the trade customer's telephone number: ", 10, 11));
				newTrade.setSurfArea(MyVal.validDouble("\n\tEnter surface area of the room: ", 0, 40000));
			
				quotes.add(newTrade);
				System.out.printf("\n\tThe paint coverage is %5.2f.\n\tThe cost of the paint required is %5.2f.", newTrade.getCoverage(), (Math.ceil(newTrade.getCoverage())*Constants.tinCost));
				break;
			}
		}
		catch (MyException e)
		{
			System.out.print(e.toString());
		}
	}
	
	public static void displayAll(ArrayList<Customer> quotes)
	{		
		for (int i=0; i<quotes.size(); i++)
		{
			System.out.print(quotes.get(i).toString());
		}
	}
	
	public static void displayQuotesByCustType(ArrayList<Customer> quotes)
	{
		int cat;
		int catCount=0;
		
		cat=MyVal.validInt("\n\n\tPlease choose a customer type.\n\t1: General Customer\n\t2: Trade Customer ", 1, 2);
		
		switch(cat)
		{
			case 1:
				for(int i=0; i<quotes.size(); i++)
				{
					if(quotes.get(i) instanceof General)
					{
						System.out.print(quotes.get(i).toString());
						catCount++;
					}
				}
				break;		
				
			case 2:
				for(int i=0; i<quotes.size(); i++)
				{
					if(quotes.get(i) instanceof Trade)
					{
						System.out.print(quotes.get(i).toString());
						catCount++;
					}
				}
				break;
		}
		System.out.print("\n\n\tTotal number of items in category: " + catCount);
	}
}