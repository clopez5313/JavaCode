import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class ArrayGameStack
{
    public static void main(String[] args) throws FileNotFoundException
    {
    	File file = new File("Path");
    	Scanner scan = new Scanner(file);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }

    private static boolean canWin(int leap, int[] game)
    {
        // Return true if you can win the game; otherwise, return false.
        int size = game.length;

        Stack<Integer> indexes = new Stack<Integer>();
        indexes.push(0);

        while(!indexes.isEmpty())
        {
            int i = indexes.pop();
            System.out.println(i);

            if(i>=size)
            {
                return true;
            }

            if(i<0 || game[i]==1)
            {
                continue;
            }

            // mark as visited
            game[i] = 1;

            indexes.push(i-1);
            indexes.push(i+1);
            indexes.push(i+leap);
        }

        return false;
    }
}
