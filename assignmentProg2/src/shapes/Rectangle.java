package shapes;

public class Rectangle extends Shape
{
	//RAttributes
	private double width;
	private double length;
		
	//Constructors
	public Rectangle()
	{
		super();
		width=0;
		length=0;
	}
		
	public Rectangle(String name, String colour, double width, double length)
	{
		super(name, colour);
		this.width=width;
		this.length=length;
	}
	
	public Rectangle(double width, double length)
	{
		super();
		this.width=width;
		this.length=length;
	}
			
	//Getters/Setters
	public double getWidth()
	{
		return width;
	}
		
	public void setWidth(double width) 
	{
		this.width=width;
	}
	
	public double getLength()
	{
		return length;
	}
		
	public void setLenth(double length)
	{
		this.length=length;
	}
	
	//Implementation of getPerimeter Method
	@Override
	public double getPerimeter()
	{
		return (length+width)*2;
	}
	
	//Implementation of getArea Method
	@Override
	public double getArea()
	{
		return length*width;
	}
	
	//Implementation of toString Method
	@Override
	public String toString()
	{
		return String.format("\n\n\t%s %s\n\tLength: %5.2f\n\tBreadth: %5.2f\n\tPerimeter: %5.2f", super.getColour(), super.getName(), length, width, getPerimeter());
	}		
}