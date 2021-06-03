import java.io.File;
import java.io.FileNotFoundException;
import java.util.BitSet;
import java.util.Scanner;

public class BitSets
{
	public static void main(String[] args) throws FileNotFoundException
	{
		File file = new File("Path");
		Scanner sc = new Scanner(file);
		int size = sc.nextInt();
		int numOps = sc.nextInt();
		BitSet set1 = new BitSet(size);
		BitSet set2 = new BitSet(size);

		for(int i=0;i<numOps;i++)
		{
			String operation = sc.next();
			int first = sc.nextInt();
			int second = sc.nextInt();

			if(operation.equals("SET") || operation.equals("FLIP"))
			{
				if(first == 1)
				{
					if(operation.equals("SET"))
					{
						set1.set(second);
					}

					else
					{
						set1.flip(second);
					}
				}

				else
				{
					if(operation.equals("SET"))
					{
						set2.set(second);
					}

					else
					{
						set2.flip(second);
					}
				}
			}

			else
			{
				if(first == 1)
				{
					if(operation.equals("AND"))
					{
						set1.and(set2);
					}

					else if(operation.equals("OR"))
					{
						set1.or(set2);
					}

					else
					{
						set1.xor(set2);
					}
				}

				else
				{
					if(operation.equals("AND"))
					{
						set2.and(set1);
					}

					else if(operation.equals("OR"))
					{
						set2.or(set1);
					}

					else
					{
						set2.xor(set1);
					}
				}
			}

			System.out.println(set1.cardinality() + " " + set2.cardinality());
		}

		sc.close();
	}
}
