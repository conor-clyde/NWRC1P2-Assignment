package customers;

import general.Constants;
import general.MyException;

public class Trade extends Customer
{
	//Attributes
	private String tradeName;

	//Constructor
	public Trade()
	{
		tradeName="";
	}
	
	public Trade(char custType, String tradeName, String custAdd, String custTele, double surfArea) 
	{
		super(custType, custAdd, custTele, surfArea);
		this.tradeName=tradeName;
	}

	//Getters/Setters
	public String getTradeName()
	{
		return tradeName;
	}

	public void setTradeName(String tradeName) throws MyException
	{
		if (tradeName.length()<2 || tradeName.length()>40)
			throw new MyException("Trade name must be between 2 and 40 characters.");
		else
			this.tradeName=tradeName;
	}
	
	//Implementation of getCoverage Method
	@Override
	public double getCoverage()
	{
		return super.getSurfArea()/Constants.coverage;
	}
	
	//Implementation oftoString Method
	@Override
	public String toString()
	{
		return String.format("\n\n\tTrade Name: %-20s%s\n\tCoverage: %-5.2f", getTradeName(), super.toString(), getCoverage());
	}	
}