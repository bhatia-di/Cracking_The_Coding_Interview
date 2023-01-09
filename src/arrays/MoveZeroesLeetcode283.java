package arrays;

import java.util.Arrays;

public class MoveZeroesLeetcode283 {

    /** Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     Note that you must do this in-place without making a copy of the array.
     Example 1:

     Input: nums = [0,1,0,3,12]
     Output: [1,3,12,0,0]

     Input: nums = [0,1,0,0,0,0,12]
     Output: [1,12,0,0,0,0]

     Example 2:

     Input: nums = [0]
     Output: [0]
     *
     */

    public void moveZeroes(int[] nums) {

        int length = nums.length;
        int snowBallSize = 0;

        for (int i=0; i<length; i++) {

            if (nums[i] == 0) {
                snowBallSize++;
            } else {
                int temp = nums[i-snowBallSize];
                nums[i-snowBallSize] = nums[i];
                nums[i] = temp;
            }

        }

    }

    public static void main(String[] args) {
        int[] input1 = new int[]{0,1,0,3,12};
        MoveZeroesLeetcode283 moveZeroesLeetcode283 = new MoveZeroesLeetcode283();
        moveZeroesLeetcode283.moveZeroes(input1);
        System.out.println(Arrays.toString(input1));

        int[] input2 = new int[]{0,0};
        moveZeroesLeetcode283.moveZeroes(input2);
        System.out.println(Arrays.toString(input2));

        int[] input3 = new int[]{1, 2};
        moveZeroesLeetcode283.moveZeroes(input3);
        System.out.println(Arrays.toString(input3));

    }



}
