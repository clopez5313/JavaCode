import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Lists {

	public static void main(String[] args) throws FileNotFoundException
	{
		File file = new File("Path");
        Scanner sc = new Scanner(file);

        int listSize = sc.nextInt();
        List<Integer> list = new LinkedList<Integer>();

        for(int i=0;i<listSize;i++)
        {
        	list.add(sc.nextInt());
        }

        int queries = sc.nextInt();

        for(int i=0;i<queries;i++)
        {
        	String query = sc.next();
        	int index = sc.nextInt();

        	if(query.equals("Insert"))
        	{
        		int element = sc.nextInt();
        		list.add(index, element);
        	}

        	else if(query.equals("Delete"))
        	{
        		list.remove(index);
        	}
        }

        for(Integer element:list)
        {
        	System.out.print(element + " ");
        }

        sc.close();
	}
}
