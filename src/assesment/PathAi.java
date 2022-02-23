package assesment;//package assesment;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PathAi {

    public static List<String> findMeetingSlots(int num_slots, List<List<String>> empSch) {
        List<String> output = new ArrayList<>();
        int[] hourSlots = new int[96];
        int size = empSch.size();

        for (int i=0; i<size; i++) {
            List<String> schedule = empSch.get(i);
            for (String s: schedule) {
                String[] times = s.split("-");
                String[] from = times[0].split(":");
                String[] to = times[1].split(":");

                int hrFrom = Integer.parseInt(from[0]);
                int minFrom = Integer.parseInt(from[1]);
                int hrTo = Integer.parseInt(to[0]);
                int minTo = Integer.parseInt(to[1]);

                //System.out.println(hrFrom + " " + minFrom + " " +  hrTo + " " + minTo);
                int currHour = 0;
                int currMin = 0;

                for (int t=0; t<hourSlots.length; t++) {

                    if (currHour > hrFrom && currHour < hrTo) {
                        hourSlots[t] = hourSlots[t] + 1;
                    }
                    else if (currHour == hrFrom && currMin >= minFrom && currHour < hrTo) {
                        hourSlots[t] = hourSlots[t] + 1;
                    } else if (currHour == hrTo && currMin < minTo ) {
                        hourSlots[t] = hourSlots[t] + 1;
                    }

                    currMin+=15;
                    if (currMin == 60) {
                        currHour+=1;
                        currMin=0;
                    }

                }
            }

        }

//        int min = Arrays.stream(hourSlots).min().getAsInt();
//        int index = num_slots;
        int currHour = 0;
        int currMin = 0;
        for (int i: hourSlots) {


            System.out.println("Slot " + currHour + ":" + currMin +  " - unavailable count " + i);
            currMin+=15;
            if (currMin == 60) {
                currHour+=1;
                currMin=0;
            }
        }


        return output;
    }

    public static void main(String[] args) {
        List<List<String>> empSch = new ArrayList<>();
        List<String> sch = new ArrayList<>();
        sch.add("00:00-02:30");
        sch.add("05:00-07:30");
        empSch.add(sch);

        findMeetingSlots(3, empSch);
    }
}






