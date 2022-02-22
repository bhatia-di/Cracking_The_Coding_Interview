package assesment;


public class Amazon {
    public static void main(String[] args) {

        String[] list = {"1101", "0100", "0010"};
        String[] output = new String[list.length];

        int[] oneRow = new int[list.length];
        int[] oneCol = new int[list[0].length()];

        int[] zeroRow = new int[list.length];
        int[] zeroCol = new int[list[0].length()];


        for (int i=0; i<list.length; i++) {

            String s = list[i];


            for (int j =0; j<s.length(); j++) {

                char c = s.charAt(j);
                if (c == '1') {

                    oneRow[i]++;
                    oneCol[j]++;

                }
                if (c == '0') {

                    zeroRow[i]++;
                    zeroCol[j]++;

                }



            }



        }

        int maxValue = Integer.MIN_VALUE;

        for (int i=0; i<list.length; i++) {

            String s = list[i];
            String o = output[i];


            System.out.println("============" + list[i].length());
            for (int j = 0; j < list[i].length(); j++) {

                int ones = oneRow[i] + oneCol[j];
                int zeros = zeroRow[i] + zeroCol[j];
                int finalVal = ones-zeros;
                o = o == null ? "" + finalVal :o  + finalVal;
                output[i] = o;
                maxValue = Math.max(maxValue, finalVal);

            }

        }

        for (String a: output) {
            System.out.println(a);
        }

        System.out.println("Max Greyness " + maxValue );







        }
    }

