import java.util.Arrays;

public class PairSumZero {

	public static void main(String[] args) {
        int array[]={1,30,-5,70,-8,20,-40,60};
        findPairWithMinSum(array);
	}

    public static void findPairWithMinSum(int arr[])
    {
    	// Sort the array, you can use any sorting algorithm to sort it
    	Arrays.sort(arr);
        int sum=0;
        int minimumSum = Integer.MAX_VALUE;
        int n=arr.length;

        if(n<0)
            return;

        // left and right index variables
        int l = 0, r = n-1;
        // variables to keep track of the left and right index pair for minimumSum
        int minLeft = l, minRight = n-1;

        while(l < r)
        {
            sum = arr[l] + arr[r];

            /*If abs(sum) is less than min sum, we need to update sum and pair */
            if(Math.abs(sum) < Math.abs(minimumSum))
            {
                minimumSum = sum;
                minLeft = l;
                minRight = r;
            }

            if(sum < 0)
                l++;

            else
                r--;
        }
        System.out.println(" The pair whose sum is minimun : "+arr[minLeft]+" "+ arr[minRight]);
    }
}
