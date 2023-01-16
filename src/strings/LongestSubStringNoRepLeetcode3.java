package strings;

import java.util.HashMap;
import java.util.Map;

/** Given a string s, find the length of the longest
substring
 without repeating characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

* */
public class LongestSubStringNoRepLeetcode3 {
    /** Hashmap and better approach than the one mentioned below
     * */

    public  int lengthOfSubStringOptimized(String s) {
        if(s == null || s.length() == 0) return 0;

        if(s.trim().length() == 0) return 1;

        Map<Character, Integer> tracker = new HashMap<>();
        int startIndex = 0; // of the string to be considered
        int strLength = s.length();
        int longestSubstringLength = 0;

        for (int i=0; i< strLength; i++) {
            char current = s.charAt(i);


            if (tracker.containsKey(current)) {

                if (tracker.get(current) >= startIndex) {
                    startIndex = tracker.get(current) + 1;
                }
            }

            longestSubstringLength = Math.max(longestSubstringLength, i-startIndex + 1);
            tracker.put(current, i);


        }

        return longestSubstringLength;
    }

    /** using string buffer - longer and less appropriate solution
     * I thought of this solution as the first pass and it ll go beyond O(N)
    * */
    public int lengthOfLongestSubstring(String s) {

        if(s == null || s.length() == 0) return 0;

        StringBuffer output = new StringBuffer("");
        int strLength = s.length();
        int currentIndex = 0;
        int longestSubStrLen = 0;

        while(currentIndex < strLength) {
            //string present
            String currentStr = s.substring(currentIndex, currentIndex+1);
            int olderIndexOutput = output.indexOf(currentStr);

            if ( olderIndexOutput >= 0) {
                // capture last str
                longestSubStrLen = Math.max(longestSubStrLen, output.length());

                // reset output
                String minusTheSame = output.substring(olderIndexOutput + 1);
                output.setLength(0);
                output.append(minusTheSame);
                output.append(currentStr);

            } else {
                output.append(s.substring(currentIndex, currentIndex+1));
                longestSubStrLen = Math.max(longestSubStrLen, output.length());
            }
            //System.out.println(currentIndex + " " + output.toString() +  " " + olderIndexOutput);

            currentIndex++;
        }

        return longestSubStrLen;


    }






    public static void main(String[] args) {
        LongestSubStringNoRepLeetcode3 longestSubStringNoRepLeetcode3 = new LongestSubStringNoRepLeetcode3();
        System.out.println(longestSubStringNoRepLeetcode3.lengthOfLongestSubstring(" "));

        System.out.println(longestSubStringNoRepLeetcode3.lengthOfLongestSubstring("au"));
        System.out.println(longestSubStringNoRepLeetcode3.lengthOfLongestSubstring("dvdf"));
        System.out.println(longestSubStringNoRepLeetcode3.lengthOfLongestSubstring("abcabcbb"));


        System.out.println("########################################################");
        System.out.println(longestSubStringNoRepLeetcode3.lengthOfSubStringOptimized(" "));

        System.out.println(longestSubStringNoRepLeetcode3.lengthOfSubStringOptimized("au"));
        System.out.println(longestSubStringNoRepLeetcode3.lengthOfSubStringOptimized("dvdf"));
        System.out.println(longestSubStringNoRepLeetcode3.lengthOfSubStringOptimized("abcabcbb"));


    }
}
