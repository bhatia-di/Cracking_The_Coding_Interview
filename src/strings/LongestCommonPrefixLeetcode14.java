package strings;

public class LongestCommonPrefixLeetcode14 {

    /**
     * Write a function to find the longest common prefix string amongst an array of strings.
     *
     * If there is no common prefix, return an empty string "".
     *
     *
     *
     * Example 1:
     *
     * Input: strs = ["flower","flow","flight"]
     * Output: "fl"
     * Example 2:
     *
     * Input: strs = ["dog","racecar","car"]
     * Output: ""
     * Explanation: There is no common prefix among the input strings.
     */

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) return "";

        if (strs.length == 1) return strs[0];

        StringBuilder result = new StringBuilder(strs[0]);

        for (int i=1; i < strs.length; i++) {

            if (result.equals(strs[i])) {
                continue;
            }

            int index  = 0;
            while (index < Math.min(result.length(), strs[i].length()) && strs[i].charAt(index) == result.charAt(index)) {
                index++;
            }
            result.delete(index, result.length());

        }

        System.out.println(result.toString());

        return result.toString();



    }

    public static void main(String[] args) {
        String[] input1 = new  String[] {"flower","flow","flight"};
        LongestCommonPrefixLeetcode14 longestCommonPrefixLeetcode14 = new LongestCommonPrefixLeetcode14();

        longestCommonPrefixLeetcode14.longestCommonPrefix(input1);

        String[] input2 = new  String[] {"ab","a"};
        longestCommonPrefixLeetcode14.longestCommonPrefix(input2);


    }
}
