package customers;

import general.*;
import shapes.*;
import java.util.Scanner;

public class General extends Customer
{
	static Scanner key = new Scanner(System.in);

	//Attributes
	private String custName;
	
	//Constructors
	public General()
	{
		super();
		custName="";
	}
	public General(char custType, String custName, String custAdd, String custTele, String roomShape, double height, double width, int noDoors, int noWindows)
	{
		super(custType, custAdd, custTele, roomShape, height, width, noDoors, noWindows);
		this.custName=custName;

	}
	
	public General(char custType, String custName, String custAdd, String custTele, String roomShape, double height, double width, double length, int noDoors, int noWindows)
	{
		super(custType, custAdd, custTele, roomShape, height, width, length, noDoors, noWindows);
		this.custName=custName;
	}

	//Getters/Setters
	public String getCustName() 
	{
		return custName;
	}

	public void setCustName(String custName) throws MyException
	{
		if (custName.length()<2 || custName.length()>40)
			throw new MyException("Customer name must be between 2 and 40 characters.");
		else
			this.custName=custName;
	}
	
	//Implementation of getCoverage Method
	@Override
	public double getCoverage()
	{
		try
		{
			switch(super.getRoomShape())
			{		
				case "rectangular":
					Rectangle rectangleRoom = new Rectangle(super.getWidth(), super.getLength());
					super.setSurfArea(super.getHeight()*rectangleRoom.getPerimeter()); 
					break;
				case "cylindrical":
					Circle cylinderRoom = new Circle(super.getWidth()/2);
					super.setSurfArea(super.getHeight()*cylinderRoom.getPerimeter());
					break;
			}
			
			return ((super.getSurfArea() - (super.getNoDoors()*Constants.door + super.getNoWindows()*Constants.window)) * Constants.wastage) / Constants.coverage;
		}
		catch (MyException e)
		{
			System.out.print(e.toString());
		}
		return 0;
	}
	
	//Implementation of toString Method
	@Override
	public String toString()
	{
		return String.format("\n\n\tCustomer Name: %-20s%s\n\tCoverage: %-5.2f", getCustName(), super.toString(), getCoverage());
	}
}