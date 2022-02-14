package shapes;

public class Circle extends Shape
{
	//Attributes
	private double radius;
		
	//Constructors
	public Circle()
	{
		super();
		radius=0.0;
	}
		
	public Circle(String name, String colour, double radius)
	{
		super(name, colour);
		this.radius=radius;
	}
	
	public Circle(double radius)
	{
		super();
		this.radius=radius;
	}
		
	//Getters/Setters
	public double getRadius()
	{
		return radius;
	}
		
	public void setRadius(double radius)
	{
		this.radius=radius;
	}
		
	//Implementation of getPerimeter Method
	@Override
	public double getPerimeter()
	{
		return Math.PI*(radius*2);
	}
	
	//Implementation of getArea Method
	@Override
	public double getArea()
	{
		return Math.PI*Math.pow(radius, 2);
	}
			
	//Implementation of toSring Method
	@Override
	public String toString()
	{
		return String.format("\n\n\tA %s %s\n\tRadius: %5.2f\n\tCirc: %5.2f", super.getColour(), super.getName(), radius, getPerimeter());
	}
}