package strings;
import java.util.*;

public class WordBreak {


    public static boolean wordBreak(String s, List<String> wordDict) {

        HashSet<String> wordSet = new HashSet<String>(wordDict);
        boolean[] dp = new boolean[s.length()];

        for (int i=0; i< s.length(); i++) {

            for (String word: wordSet) {
                int length = word.length();
                System.out.println(length);


                if (word.equals(s.substring(i, i + length))) {
                    dp[i + length - 1] = true;
                    i = i+length -1;
                    System.out.println(i);

                    break;
                }


            }

        }

        return dp[s.length() -1];





    }
    public static void main(String args[]) {
        List<String> list = new ArrayList<String>() {{
            add("leet");
            add("code");
        } };
        String s = "leetcode";
        boolean m = wordBreak(s, list);

    }



}
