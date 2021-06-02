import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Maps {

	public static void main(String[] args) throws FileNotFoundException
	{
		File file = new File("Path");
		Scanner in = new Scanner(file);
		int n=in.nextInt();
		in.nextLine();
		Map<String, Integer> map = new HashMap<String, Integer>();

		for(int i=0;i<n;i++)
		{
			String name=in.nextLine();
			int phone=in.nextInt();
			map.put(name, phone);
			in.nextLine();
		}

		while(in.hasNext())
		{
			String s=in.nextLine();

			try
			{
				int number = map.get(s);
				System.out.println(s + "=" + number);
			}

			catch(NullPointerException e)
			{
				System.out.println("Not found");
			}
		}

		in.close();
	}
}
