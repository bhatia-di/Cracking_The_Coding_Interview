package assesment;

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
    }
}
