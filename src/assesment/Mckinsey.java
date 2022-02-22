package assesment;

import java.util.ArrayList;
import java.util.List;

public class Mckinsey {

    public static void main(String[] args) {
        //int[] stock = new int[]{5, 3,5, 7,8, 1, 3, 5, 7,8};
        int[] stock = new int[]{4,1,2,3,4, 4};
        //int k=3;
        int k=4;
        int mainCount = 0;

        for (int i=0;i<stock.length; i++) {

            int currIndex = i;
            int months = k-1;

            while (months>0 && currIndex<stock.length && currIndex+1< stock.length) {

                if (stock[currIndex] < stock[currIndex+1]) {
                    months--;
                    System.out.println(stock[currIndex] + " --- " + stock[currIndex+1] + " -- " + months);

                    currIndex++;

                } else {
                    break;
                }
            }

            if (months ==0) mainCount++;

        }

        System.out.println(mainCount);

        System.out.println(" ---------------  ");


        //System.out.println(highlyProfitableMonths());

        List<Integer> input = new ArrayList<>();
        input.add(5);
        input.add(3);input.add(5);input.add(7);input.add(8);
        System.out.println(countHighlyProfitableMonths(input, 3));

    }

    public static int highlyProfitableMonths() {
        //int[] stock = new int[]{7,1,2,3,6,9,12,3};
        int[] stock = new int[]{5,3,5,6};

        //int k=3;
        int k=2;
        int mainCount = 0;

        int left=0, right = left+1;
        int months = 0;
        while (left<stock.length && right<stock.length) {
            System.out.println(stock[right -1] + " ---- " + stock[right]);
            if (stock[right-1] < stock[right]) {
                if (months == 0) months =2;
                else {
                    months++;

                }
            } else {
                left++;
                months = 0;
            }

            if (months == k) {
                mainCount++;
                left++;
                months = 1;
                System.out.println("Mian ct " + mainCount);
                System.out.println("left " + left);
                System.out.println("months " + months);

            }
            right++;

        }

        System.out.println("final count " + mainCount);

        return mainCount;
    }

    public static int countHighlyProfitableMonths(List<Integer> stockPrices, int k) {
        // Variable to hold number of groups of k consecutive months which were
        // highly profitable
        int profitableGrpCount = 0;

        // Variable to indicate the index where the stock price was not
        // profitable compared to the previous price
        int mismatchIdx = 0;

        // Find groups k months which were highly profitable
        for (int i = 1; i < stockPrices.size(); i++) {

            // Check if price at i is less than or equal to that at (i - 1)
            if (stockPrices.get(i) <= stockPrices.get(i - 1)) {

                // Set mismatchIdx to i
                mismatchIdx = i;
            }

            // Check if (mismatchIdx to i) makes a group of k prices
            if (((i - mismatchIdx + 1) == k) || ((i - mismatchIdx) >= k)) {
                System.out.println("Mis " + mismatchIdx + " i: "+ i);
                profitableGrpCount += 1; // Increment profitableGrpCount by 1

            }
        }

        // Return profitableGrpCount
        return profitableGrpCount;
    }

}
