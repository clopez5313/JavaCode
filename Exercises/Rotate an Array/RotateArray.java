public class RotateArray {

	public static void main(String[] args) {
        int nums[]={1,2,3,4,5,6,7,8,9,10};
        System.out.println("Rotate array by shifting one elements by 1 and do it 4 times");
        int[] result=rotate(nums,4);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+" ");
        }
	}

	private static int[] rotate(int[] nums,int k)
    {
        int n=nums.length;

        if(k > n)
            k=k%n;

        nums=reverse(nums,0,n-1);
        nums=reverse(nums,0,k-1);
        nums=reverse(nums,k,n-1);

        return nums;
    }

    private static int[] reverse(int[] nums,int start,int end)
    {
        while (start <= end ) {
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }

        return nums;
    }
}
