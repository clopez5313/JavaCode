public class DivisorSum {

	public static void main(String[] args)
	{
		int num = 20;

		System.out.println(divisor_sum(num));
	}

	private static int divisor_sum(int n)
    {
        int sum = 0;

        for(int i=1;i<=Math.sqrt(n);i++)
        {
            if(n%i==0)
            {
                if(i==(n/i))
                {
                    sum += i;
                }
                else
                {
                    sum += (i + (n/i));
                }
            }
        }

        return sum;
    }
}
