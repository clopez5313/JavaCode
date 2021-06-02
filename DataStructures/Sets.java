import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Sets
{
	public static void main(String[] args) throws FileNotFoundException
	{
		File file = new File("Path");
		Scanner sc = new Scanner(file);
		int numPairs = sc.nextInt();
		Set<String> set = new HashSet<String>();

		for(int i=0;i<numPairs;i++)
		{
			String firstItem = sc.next();
			String secondItem = sc.next();
			set.add("(" + firstItem + ", " + secondItem + ")");
			System.out.println(set.size());
		}

		sc.close();
	}
}
