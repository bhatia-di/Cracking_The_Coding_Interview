package assesment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IBM {
    public static void main(String[] args) {
        getValidString();
    }
    public static void getValidString() {

        //Scanner sc = new Scanner(System.in);
        //StringBuffer s = new StringBuffer();
        String patternstring = "\\(((\\+|-)?((([0-9]|[1-8][0-9])(\\.\\d+)?)|90(\\.0+)?)), ((\\+|-)?((([0-9]|[1-9][0-9]|1[0-7][0-9])(\\.\\d+)?)|180(\\.0+)?))\\)";
        Pattern p = Pattern.compile(patternstring);
        int numOfLines = 0;
//        if(sc.hasNextLine()){
//            numOfLines = Integer.valueOf(sc.nextLine());
//        }
//        while(numOfLines > 0){

          //  numOfLines--;
        //}


        List<String> input = new ArrayList<>();
        input.add("(90, 180)");
        input.add("(855,95W)");

        for (int i =0; i<input.size(); i++) {

            Matcher m = p.matcher(input.get(i));
            if(m.find()){
                System.out.println("Valid");
            }else{
                System.out.println("Invalid");
            }

        }

        // String line = sc.nextLine();


    }
}
