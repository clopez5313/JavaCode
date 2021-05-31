import java.util.Arrays;

public class Anagrams
{
    static boolean isAnagram(String a, String b)
    {
        // Complete the function
        char[] arrA = a.toLowerCase().toCharArray();
        char[] arrB = b.toLowerCase().toCharArray();
        Arrays.sort(arrA);
        Arrays.sort(arrB);

        String strA = String.valueOf(arrA);
        String strB = String.valueOf(arrB);

        if(strA.equals(strB))
        {
            return true;
        }

        return false;
    }

	public static void main(String[] args)
	{
		String a = "anagram";
		String b = "margana";

		if(isAnagram(a, b))
		{
			System.out.println("Anagrams");
		}

		else
		{
			System.out.println("Not Anagrams");
		}
	}
}
