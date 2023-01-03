package arrays;

import java.util.Arrays;

/**
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
 *
 * Increment the large integer by one and return the resulting array of digits.
 *
 *
 *
 * Example 1:
 *
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 * Example 2:
 *
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Incrementing by one gives 4321 + 1 = 4322.
 * Thus, the result should be [4,3,2,2].
 *
 * Example 3:
 *
 * Input: digits = [9]
 * Output: [1,0]
 * Explanation: The array represents the integer 9.
 * Incrementing by one gives 9 + 1 = 10.
 * Thus, the result should be [1,0].
* */
public class PlusOneLeetcode66 {

    public int[] plusOne(int[] digits) {

        int len = digits.length;

        if (digits[len - 1] < 9) {
            digits[len - 1]++;
            return digits;
        }

        // but if there is 9 at the last place and the ending digit is 9
        // eg. 899 get the index till the 9s end

        int lastIndexOf9 = len-1;
        for (int i=len-1; i>=0; i--) {

            if(digits[i] == 9) {
                lastIndexOf9 = i;

            } else {
                break;
            }

        }

        System.out.println("Lastindex " + lastIndexOf9);
        if (lastIndexOf9 == 0) {
            int[] result = new int[len+1];
            result[0] = 1;
            return result;

        }



        for (int i=0;i<len; i++) {

            if (i == lastIndexOf9 -1) {
                digits[i]+=1;
            }

            if (i >= lastIndexOf9) {
                digits[i] = 0;
            }



        }
        return digits;








    }

    public static void main(String[] args) {
        int[] input1 = new int[] {9,8,9};
        PlusOneLeetcode66 plusOneLeetcode66 = new PlusOneLeetcode66();

        int[] output = plusOneLeetcode66.plusOne(input1);
        System.out.println(Arrays.toString(output));
    }
}
