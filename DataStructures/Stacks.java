import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Stacks
{
	public static void main(String[] args) throws FileNotFoundException
	{
		File file = new File("C:\\Users\\cmorlas\\eclipse-workspace\\JavaHackerrank\\src\\DataStructures\\Stack.txt");
		Scanner sc = new Scanner(file);
		Stack<Character> stack = new Stack<Character>();

		while(sc.hasNext())
		{
			String input = sc.next();
			char[] charArray = input.toCharArray();

			if(charArray.length%2!=0)
			{
				System.out.println("false");
			}

			else
			{
				for(int i=0;i<charArray.length;i++)
				{
					if(charArray[i]=='(' || charArray[i]=='[' || charArray[i]=='{')
					{
						stack.push(charArray[i]);
						continue;
					}

					if(!stack.isEmpty())
					{
						if((charArray[i]==')' && stack.peek()=='(') || (charArray[i]==']' && stack.peek()=='[') ||
						   (charArray[i]=='}' && stack.peek()=='{'))
						{
							stack.pop();
							continue;
						}
					}

					if(charArray[i]==')' || charArray[i]==']' || charArray[i]=='}')
					{
						stack.push(charArray[i]);
						break;
					}
				}

				System.out.println(stack.isEmpty());
				stack.clear();
			}
		}

		sc.close();
	}
}
