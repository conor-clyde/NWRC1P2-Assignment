package general;

public class MyException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public MyException(String s)
	{
		message=s; 
	}
	
	public MyException()
	{
		message= "Invalid Data entered"; 
	}
	
	public String toString()
	{
		return "**My Exception: "+ message;
	}
}
