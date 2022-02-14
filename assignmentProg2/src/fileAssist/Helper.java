package fileAssist;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;

public class Helper 
{
	static private List<String> records=null;
	
	public static List<String> readFileIntoList(String file) throws IOException
	{
		try
		{
			records = Files.readAllLines(Paths.get(file));
		}
		catch (NoSuchFileException nsfe)
		{
			System.out.println("No such file exception");
			System.out.println(nsfe.getMessage());
			nsfe.printStackTrace();
		}
		catch (FileNotFoundException fnfe)
		{
			System.out.println("File not found exception");
			System.out.println(fnfe.getMessage());
			fnfe.printStackTrace();
		}
		//finally
		//{
			//System.out.println("All Done");
		//}
		return records;
	}
}
