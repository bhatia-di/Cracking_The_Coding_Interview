package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UniqueFileName {

    public String[] getFolderNames(String[] names) {

        Map<String, Integer> tracker = new HashMap<>();
        String pattern = "[\\(]{1}[0-9]+[\\)]{1}$";

        // Create a Pattern object
        Pattern endsWith = Pattern.compile(pattern);
        for (String s: names) {
            Matcher m = endsWith.matcher(s);
            while(m.find()) {
                System.out.println(m.start());
            }

        }






        return names;

    }

}
