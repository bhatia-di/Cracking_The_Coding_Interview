package binaryTree;

import java.util.HashMap;

public class Reverse {

    public static int getDistinctValues(int[] input) {
        HashMap<Integer, Integer> tracker = new HashMap<>();
        int unique = 0;

        for (int in:input) {
            int noCount = tracker.getOrDefault(in, 0);
            if(noCount == 0) {
                System.out.println(in);
                unique++;
            };
            tracker.put(in,  noCount+1);
            int reverse = reverseNumber(in);

            int reverseCount = tracker.getOrDefault(reverse, 0);
            if (reverseCount ==0) {
                System.out.println(reverse);
                unique++;
            }
            tracker.put(reverse, tracker.getOrDefault(reverse, 0) +1);
        }

        return unique;
    }

    public static int reverseNumber(int number) {
        int reverse = 0;
        while(number != 0)
        {
            int remainder = number % 10;
            reverse = reverse * 10 + remainder;
            number = number/10;
        }
        return reverse;
    }

    public static void main(String[] args) {
        int[] input = new int[]{21, 99, 99, 21, 12};
        int result = getDistinctValues(input);
        System.out.println(result);
    }
}
