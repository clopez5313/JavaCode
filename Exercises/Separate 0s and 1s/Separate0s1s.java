public class Separate0s1s {

	public static void main(String[] args)
	{
		int arr[]={0,1,0,0,1,1,1,0,1};
		System.out.println("Original Array: ");

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}

		arr=separate0s1sSolution(arr);
		System.out.println("\nArray after separating 0's and 1's : ");

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}

	public static int[] separate0s1sSolution(int arr[])
	{
		int count=0;

		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==0)
			{
				count++;
			}
		}

		for (int i = 0; i < count; i++) {
			arr[i]=0;
		}

		for (int i = count; i < arr.length; i++) {
			arr[i]=1;
		}

		return arr;
	 }
}
