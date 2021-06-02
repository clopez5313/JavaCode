import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Array2D {

	public static void main(String[] args) throws FileNotFoundException
	{
		File file = new File("Path");
        Scanner sc = new Scanner(file);

        int[][] matrix = new int[6][6];

        for(int i=0;i<6;i++)
        {
            for(int j=0;j<6;j++)
            {
                matrix[i][j] = sc.nextInt();
            }
        }

        sc.close();

        int max = Integer.MIN_VALUE;

        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                int sum = hourglassSum(matrix,i,j);
                max = Math.max(max,sum);
            }
        }

        System.out.println(max);
	}

	private static int hourglassSum(int[][] arr, int r, int c)
    {
        int sum = arr[r+0][c+0] + arr[r+0][c+1] + arr[r+0][c+2] + arr[r+1][c+1]
                + arr[r+2][c+0] + arr[r+2][c+1] + arr[r+2][c+2];

        return sum;
    }
}
