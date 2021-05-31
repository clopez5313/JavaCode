import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class StringTokens {

    public static void main(String[] args) {
        String s = "He is a very very good boy, isn't he?";
        // Write your code here.
        String regEx = "[a-zA-Z]+";
        List<String> tokens = new ArrayList<String>();
		Pattern tokSplitter = Pattern.compile(regEx);
		Matcher m = tokSplitter.matcher(s);

		while(m.find())
		{
			tokens.add(m.group());
		}

        System.out.println(tokens.size());

        for(String token:tokens)
        {
            System.out.println(token);
        }
    }
}
