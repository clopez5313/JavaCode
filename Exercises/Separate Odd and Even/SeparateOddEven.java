public class SeparateOddEven {

	public static void main(String[] args) {
		int arr[]={12, 17, 70, 15, 22, 65, 21, 90};
		System.out.println("Original Array: ");

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}

		arr=separateEvenOddNumbers(arr);
		System.out.println("\nArray after separating even and odd numbers : ");

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}

	}

	public static int[] separateEvenOddNumbers(int arr[])
	{
		int left=0;
		int right=arr.length-1;

		for (int i = 0; i < arr.length; i++) {

			while(arr[left]%2==0)
			{
				left++;
			}

			// System.out.println("\nThe value of left is " + left + " after " + i + " loops");

			while(arr[right]%2==1)
			{
				right--;
			}

			// System.out.println("The value of right is " + right + " after " + i + " loops");

			if(left<right)
			{
				int temp=arr[left];
				// System.out.println("The value of temp is " + temp + " after " + i + " loops");
				arr[left]=arr[right];
				// System.out.println("The value of arr[" + left + "] is " + arr[left] + " after " + i + " loops");
				arr[right]=temp;
				// System.out.println("The value of arr[" + right + "] is " + arr[right] + " after " + i + " loops");
			}
		}

		return arr;
	}
}
