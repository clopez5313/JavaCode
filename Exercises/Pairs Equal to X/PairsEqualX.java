import java.util.Arrays;

public class PairsEqualX {

	public static void main(String[] args) {
        int array[] = { -40, -5, 1, 3, 6, 7, 8, 20 };
        findPairsEqualsToX(array, 15);
	}

    public static void findPairsEqualsToX(int arr[], int X)
    {
    	int n = arr.length;

    	if (n < 2)
            return;

        Arrays.sort(arr);
        System.out.println("The pair whose sum is closest to 15 : ");
        // left and right index variables
        int l = 0, r = n - 1;

        while (l < r) {
            int currentSum = arr[l] + arr[r];

            if (currentSum == X) {
                System.out.println(arr[l] + " " + arr[r]);
                l++;
                r--;
            }

            else if (arr[l] + arr[r] < X)
                l++;

            else
                r--;
        }
    }
}
