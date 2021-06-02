import java.util.*;

public class SmallestLargestSubstring
{
	public static String getSmallestAndLargest(String s, int k)
	{
        String smallest = "";
        String largest = "";

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        List<String> list = new ArrayList<String>();

        for(int i = 0;i < s.length();i++)
        {
            if(i + k <= s.length())
            {
                list.add(s.substring(i, i + k));
            }

            else
            {
                break;
            }
        }

        Collections.sort(list);
        smallest = list.get(0);
        largest = list.get(list.size() - 1);

        return smallest + "\n" + largest;
    }

	public static void main(String[] args)
	{
		String s = "welcometojava";
		int k = 3;

		System.out.println(getSmallestAndLargest(s, k));
	}

}
