public class Palindrome
{
    public static void main(String[] args)
    {
        String word="madam";
        char[] str = word.toCharArray();
        String palindrome = "Yes";

        for(int i=0;i < str.length/2;i++)
        {
            if(str[i] != str[str.length - i - 1])
            {
                palindrome = new String("No");
                break;
            }
        }

        System.out.print(palindrome);
    }
}
