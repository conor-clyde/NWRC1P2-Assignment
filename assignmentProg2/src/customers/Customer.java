package customers;

import general.*;

public class Customer 
{
	//Attributes
	private char custType;
	private String custAdd, custTele, roomShape;
	private double surfArea, height, width, length;
	private int noDoors, noWindows;
		
	//Constructors
	public Customer()
	{
		custType=' ';
		custAdd="";
		custTele="";
		roomShape="";
		surfArea=0;
		height=0;
		width=0;
		length=0;
	}
	
	public Customer(char custType, String custAdd, String custTele, double surfArea)
	{
		this.custType=custType;
		this.custAdd=custAdd;	
		this.custTele=custTele;
		this.surfArea=surfArea;	
	}

	public Customer(char custType, String custAdd, String custTele, String roomShape, double height, double width, int noDoors, int noWindows)
	{
		this.custType=custType;
		this.custAdd=custAdd;
		this.custTele=custTele;
		this.roomShape=roomShape;
		this.height=height;
		this.width=width;
		this.noDoors=noDoors;
		this.noWindows=noWindows;
	}
	
	public Customer(char custType, String custAdd, String custTele, String roomShape, double height, double width, double length, int noDoors, int noWindows)
	{
		this.custType=custType;
		this.custAdd=custAdd;
		this.custTele=custTele;
		this.roomShape=roomShape;
		this.height=height;
		this.width=width;
		this.length=length;
		this.noDoors=noDoors;
		this.noWindows=noWindows;
	}

	//Getters/Setters
	public char getCustType() 
	{
		return custType;
	}

	public void setCustType(char custType) throws MyException
	{
		if (custType != 'G' && custType !='T')
			throw new MyException("Customer type must be G for General or T for Trade.");
		else
			this.custType=custType;
	}

	public String getCustAdd() 
	{
		return custAdd;
	}

	public void setCustAdd(String custAdd) throws MyException
	{
		if (custAdd.length()<5 || custAdd.length()>40)
			throw new MyException("Customer address must be between 5 and 40 characters.");
		else
			this.custAdd=custAdd;
	}

	public String getCustTele() 
	{
		return custTele;
	}

	public void setCustTele(String custTele) throws MyException 
	{
		if (custTele.length()<10 || custTele.length()>11)
			throw new MyException("Customer telephone number must be between 10 and 11 characters.");
		else
			this.custTele=custTele;
	}

	public double getSurfArea() 
	{
		return surfArea;
	}

	public void setSurfArea(double surfArea) throws MyException
	{
		if (surfArea<0 || surfArea>40000)
			throw new MyException("Surface area must not be negative or greater than 40,000.");
		else
			this.surfArea=surfArea;
	}

	public String getRoomShape() 
	{
		return roomShape;
	}

	public void setRoomShape(String roomShape) throws MyException
	{
		if (roomShape.equals("rectangular") && roomShape.equals("cylindrical"))
			throw new MyException("Room shape should be rectangular or cylindrical.");
		else
			this.roomShape=roomShape;
	}

	public double getHeight() 
	{
		return height;
	}

	public void setHeight(double height) throws MyException
	{
		if (height<0 || height>100)
			throw new MyException("Height must not be negative or greater than 100.");
		else
			this.height=height;
	}
		
	public double getWidth() 
	{
		return width;
	}

	public void setWidth(double width) throws MyException
	{
		if (width<0 || width>100)
			throw new MyException("Width must not be negative or greater than 100.");
		else
			this.width=width;
	}
	
	public double getLength()
	{
		return length;
	}
	
	public void setLength(double length) throws MyException
	{
		if (length<0 || length>100)
			throw new MyException("Length must not be negative or greater than 100.");
		else
			this.length=length;
	}
	
	public int getNoDoors()
	{
		return noDoors;
	}
	
	public void setNoDoors(int noDoors) throws MyException
	{
		if (noDoors<0 || noDoors>10)
			throw new MyException("The number of doors should be between 1 and 10.");
		else
			this.noDoors=noDoors;
	}
	
	public int getNoWindows()
	{
		return noWindows;
	}
	
	public void setNoWindows(int noWindows) throws MyException
	{
		if (noWindows<0 || noWindows>20)
			throw new MyException("The number of windows should be between 1 and 20.");
		else
			this.noWindows=noWindows;
	}

	//Methods
	public double getCoverage()
	{
		return 0;
	}
	
	//toString Method
	public String toString()
	{
		return String.format("\n\tCustomer Type: %c\n\tCustomer Address: %-30s\n\tCustomer Telephone: %-11s\n\tRoom Shape: %-11s\n\tHeight: %-5.2f\n\tWidth: %-5.2f\n\tLength: %-5.2f\n\tSurface Area: %-5.2f", getCustType(), getCustAdd(), getCustTele(), getRoomShape(), getHeight(), getWidth(), getLength(), getSurfArea());	
	}
}




