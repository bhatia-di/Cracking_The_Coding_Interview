//package assesment;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Cisco {
//
// check for valid IP
//
//    public static void main(String[] args) {
//        String ip = "64.58.90.122";
//        String[] input = ip.split("\\.");
//        String output = "VALID";
//
//
//        if (input.length != 4 ) {
//
//            output = "INVALID";
//        }
//        for (String s: input) {
//            int value = Integer.parseInt(s);
//            if(!(value >=0 && value <= 255)) {
//
//                output = "INVALID";
//                break;
//            }
//        }
//        System.out.println(output);
//    }
//
//    public static void getSumOfDigits() {
//        int numX=20;
//        int numY=5;
//
//        int ans = 0;
//        for (int i=0; i<=numX; i++) {
//            int digit, sum =0;
//            int num = i;
//
//            // 25 26 27 1 10
//            while(num>0){
//                // 50%10
//                digit = num%10;
//                sum+=digit;
//                num=num/10;
//
//            }
//            System.out.println("sum " + sum);
//
//            if (sum == numY)  ans++;
//        }
//
//        System.out.println(ans);
//    }
//
//
//    public static void getMaxDiff() {
//            int[] arr = new int[]{25, 26, 27, 1, 10};
//            int maxDiff = Integer.MIN_VALUE;
//
//
//            for (int i=0; i<arr.length; i++) {
//
//            }
//
//
//    }
//}


