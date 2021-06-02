import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayLists {

	public static void main(String[] args) throws FileNotFoundException
	{
		File file = new File("Path");
        Scanner sc = new Scanner(file);

        int size = sc.nextInt();
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();

        for(int i=0;i<size;i++)
        {
        	int numElements = sc.nextInt();
        	ArrayList<Integer> list = new ArrayList<Integer>();

        	for(int j=0;j<numElements;j++)
        	{
        		list.add(sc.nextInt());
        	}

        	mainList.add(list);
        }

        int numQueries = sc.nextInt();

        for(int i=0;i<numQueries;i++)
        {
        	int xLine = sc.nextInt();
        	int yPos = sc.nextInt();
        	ArrayList<Integer> list = mainList.get(xLine-1);

        	try
        	{
        		int num = list.get(yPos-1);
        		System.out.println(num);
        	}

        	catch(IndexOutOfBoundsException e)
        	{
        		System.out.println("ERROR!");
        	}

        }

        sc.close();
	}

}
