package assesment;

import java.util.ArrayList;
import java.util.List;

public class Cisco {

// check for valid IP

    public static void main(String[] args) {
        String ip = "64.58.90.122";
        String[] input = ip.split("\\.");
        String output = "VALID";


        if (input.length != 4 ) {

            output = "INVALID";
        }
        for (String s: input) {
            int value = Integer.parseInt(s);
            if(!(value >=0 && value <= 255)) {

                output = "INVALID";
                break;
            }
        }
        System.out.println(output);
    }
}
