package shapes;

public class Shape 
{
	//Attributes
	private String name;
	private String colour;
	
	//Constructors
	public Shape()
	{
		name="";
		colour="";
	}
	
	public Shape(String name, String colour)
	{
		this.name=name;
		this.colour=colour;
	}
	
	//Getters/Setters
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public String getColour()
	{
		return colour;
	}
	
	public void setColour(String colour)
	{
		this.colour=colour;
	}
	
	//Method
	public double getPerimeter()
	{
		return 0;
	}
	
	public double getArea()
	{
		return 0;
	}
	
	//toString Method
	public String toString()
	{
		return String.format("\n\n\t%s %s", colour, name);
	}
}