import java.util.HashMap;
import java.util.Map;

/** Given a string, find the length of the longest substring
    in it with no more than K distinct characters.
 */


public class LongestSubStringWithKCharacters {

    public static int findMaxSubStringLength(String input, int k) {
        char[] in = input.toCharArray();
        int windowStart = 0;
        int subStringLength = 0;
        Map<Character, Integer> frequency = new HashMap<Character, Integer>();

        for (int window = 0; window< in.length; window++) {

            char c = in[window];
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);


            while(frequency.size() > k) {

                char start = in[windowStart];
                int freqStart = frequency.getOrDefault(start, 0) - 1;
                if (freqStart == 0) frequency.remove(start);
                else {
                    frequency.put(start, freqStart-1);
                  }

                windowStart++;
            }

            subStringLength = Math.max(subStringLength, window - windowStart + 1);



        }





        return subStringLength;
    }


    public static void main(String[] args) {

        System.out.println(findMaxSubStringLength("cbbebi", 3));

    }
}
