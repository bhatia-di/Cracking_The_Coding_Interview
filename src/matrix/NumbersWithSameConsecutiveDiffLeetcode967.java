package matrix;

import java.util.*;

public class NumbersWithSameConsecutiveDiffLeetcode967 {
    /** 967. Numbers With Same Consecutive Differences
     Medium
     2.6K
     188
     company
     Bloomberg
     company
     Google
     company
     Yahoo
     Given two integers n and k, return an array of all the integers of length n where the difference between every two consecutive digits is k. You may return the answer in any order.

     Note that the integers should not have leading zeros. Integers as 02 and 043 are not allowed.



     Example 1:

     Input: n = 3, k = 7
     Output: [181,292,707,818,929]
     Explanation: Note that 070 is not a valid number, because it has leading zeroes.
     Example 2:

     Input: n = 2, k = 1
     Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]


     Constraints:

     2 <= n <= 9
     0 <= k <= 9

     * */


    // this approach only creates pairs, but if the k value is small like k =2 then this approach
    // doesn't consider that 246 is also a right value, thats why we ll have to a DFS.

    public void dfs(int number, int N, int k, Set<Integer> output) {


        if(N==1) {

            output.add(number);
            return;

        }

        // get the last digit
        int lastDigit = number % 10;
        if (inRange(lastDigit+k)) {
            int nextNumber1 = number * 10 + (lastDigit + k);
            dfs(nextNumber1, N-1, k, output);
        }
        if (inRange(lastDigit-k)) {
            int nextNumber1 = number * 10 + (lastDigit-k);
            dfs(nextNumber1, N-1, k, output);
        }





    }
    public boolean inRange(int number) {
        return number >=0 && number <=9;
    }

    public int[] numsSameConsecDiff(int n, int k) {
        int[] POWERS_OF_10 = { 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
        if (n == 0) {
            // have to handle this separately
            return new int[]{0};
        }
        int totalLengthOfPairs = 9-k+1;
        int outputLength = (totalLengthOfPairs * 2) -1;

        int[][] pairs = new int[totalLengthOfPairs][2];

        int currentIndex = 0;

        for (int i=k; i<=9; i++) {
            pairs[currentIndex][0] = i;
            pairs[currentIndex][1] = Math.abs(k - i);

            System.out.println(Arrays.toString(pairs[currentIndex]));
            currentIndex++;
        }
        //System.out.println("########");
        Set<Integer> output = new HashSet<>();
        for (int i=0; i<totalLengthOfPairs; i++) {
            int left = pairs[i][0];
            int right = pairs[i][1];
            int hundreds = POWERS_OF_10[n-1];
            int result1 = 0;
            int result2 = 0;
            boolean leftInd = true;
            while (hundreds>0) {
                if (leftInd) {
                    result1 = result1 + (hundreds * left);
                    result2 = result2 + (hundreds * right);
                } else {
                    result1 = result1 + (hundreds * right);
                    result2 = result2 + (hundreds * left);
                }

                leftInd = !leftInd;
                hundreds = hundreds/10;
            }

            if(result1>= POWERS_OF_10[n-1]){
                output.add(result1);
            }
            if(result2>= POWERS_OF_10[n-1]){
                output.add(result2);
            }

        }
        int[] finalOp = new  int[output.size()];
        int outputIndex = 0;
        for (int element: output) {
            finalOp[outputIndex++] = element;
        }

        return finalOp;

    }

    public int[] numsSameConsecDiffWithDFS(int n, int k) {
        List<Integer> digitList = Arrays.asList( 1 , 2 , 3 , 4, 5, 6, 7, 8, 9);
        if (k == 1) digitList.add(0);

        Set<Integer> output = new HashSet<>();


        for (Integer element: digitList) {
                dfs(element, n, k, output);
        }


       int[] outputArr = new int[output.size()];
        int currentIndex =0;

        for(Integer element: output){
            outputArr[currentIndex++] = element;
        }
        return outputArr;



    }

    public static void main(String[] args) {
        NumbersWithSameConsecutiveDiffLeetcode967 numbersWithSameConsecutiveDiffLeetcode967 = new NumbersWithSameConsecutiveDiffLeetcode967();
        //System.out.println(Arrays.toString(numbersWithSameConsecutiveDiffLeetcode967.numsSameConsecDiff(2, 0)));
        //System.out.println(Arrays.toString(numbersWithSameConsecutiveDiffLeetcode967.numsSameConsecDiff(3, 7)));
        //System.out.println(Arrays.toString(numbersWithSameConsecutiveDiffLeetcode967.numsSameConsecDiff(4, 2)));

        //System.out.println(Arrays.toString(numbersWithSameConsecutiveDiffLeetcode967.numsSameConsecDiff(3, 2)));
        System.out.println(Arrays.toString(numbersWithSameConsecutiveDiffLeetcode967.numsSameConsecDiffWithDFS(3, 2)));

        System.out.println(Arrays.toString(numbersWithSameConsecutiveDiffLeetcode967.numsSameConsecDiffWithDFS(2, 0)));



    }
}
