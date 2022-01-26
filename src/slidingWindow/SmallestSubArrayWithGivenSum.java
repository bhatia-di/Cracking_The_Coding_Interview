package slidingWindow;

/*** Given an array of positive numbers and a positive number ‘S,’
 *  find the length of the smallest contiguous subarray whose sum is greater than
 *  or equal to ‘S’. Return 0 if no such subarray exists.
 *
 *
 * The time complexity of the above algorithm will be O(N)O(N).
 * The outer for loop runs for all elements, and the inner while loop processes
 * each element only once; therefore, the time complexity of the algorithm will be O(N+N)O(N+N),
 * which is asymptotically equivalent to O(N)O(N).
 * */

public class SmallestSubArrayWithGivenSum {

    public static int smallestSubArray(int[] arr, int k) {
        int windowStart = 0;
        int smallestSubArrayLength = Integer.MAX_VALUE;
        int windowSum = 0;

        for (int window = 0; window < arr.length; window++) {
            windowSum += arr[window];

            while (windowSum >= k) {
                smallestSubArrayLength = Math.min(smallestSubArrayLength, window - windowStart +1);
                windowSum -= arr[windowStart];
                windowStart ++;

            }


        }


        return smallestSubArrayLength == Integer.MAX_VALUE ? 0 : smallestSubArrayLength;

    }



    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 5, 2, 8};
        System.out.println(smallestSubArray(arr, 7));
    }
}
