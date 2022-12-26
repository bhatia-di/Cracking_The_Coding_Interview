package arrays;

import java.util.Arrays;

/**
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 *
 */

class SortedSquare {
    public int[] sortedSquares(int[] nums) {

        int[] output = new int[nums.length];
        int firstIdx = 0;
        int lastIdx = nums.length -1;
        int ouputIndex = nums.length -1;

        while (ouputIndex >= 0 && firstIdx <  nums.length && lastIdx >= 0) {

            if (Math.abs(nums[firstIdx]) < Math.abs(nums[lastIdx])) {

                System.out.println(nums[firstIdx] + " , " + nums[lastIdx]);
                output[ouputIndex] = nums[lastIdx] * nums[lastIdx];
                ouputIndex--;
                lastIdx--;

            } else if (Math.abs(nums[firstIdx]) > Math.abs(nums[lastIdx])) {
                System.out.println(" else if " + nums[firstIdx] + " , " + nums[lastIdx]);
                output[ouputIndex] = nums[firstIdx] * nums[firstIdx];
                ouputIndex--;
                firstIdx++;

            } else {
                output[ouputIndex] = nums[lastIdx] * nums[lastIdx];
                ouputIndex--;
                lastIdx--;

            }


        }

        System.out.println(Arrays.toString(output));

        return output;

    }

    public static void main(String[] args) {
        int[] nums  = new int[] {-7,-3,2,3,11};

        SortedSquare sortedSquare = new SortedSquare();
        sortedSquare.sortedSquares(nums);

    }
}