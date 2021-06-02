import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BigDecimals
{

	public static void main(String[] args) throws FileNotFoundException
	{
		    File file = new File("File Path");
        Scanner in = new Scanner(file);
        int cases = Integer.parseInt(in.nextLine());

        String []s=new String[cases+2];
        for(int i=0;i<cases;i++){
            s[i]=in.next();
        }

        in.close();

        //Write your code here
        Comparator<String> comp = new Comparator<String>()
        {
        	   @Override
			       public int compare(String o1, String o2)
        	   {
				           BigDecimal num1 = new BigDecimal(o1);
				           BigDecimal num2 = new BigDecimal(o2);

				           return num2.compareTo(num1);
			       }
        };

        Arrays.sort(s, 0, cases, comp);

        //Output
        for(int i=0;i<cases;i++)
        {
            System.out.println(s[i]);
        }

	}
}
