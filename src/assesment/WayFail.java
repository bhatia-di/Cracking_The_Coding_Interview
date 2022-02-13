package assesment;

import strings.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class WayFail {




    public static int findORow(String[] chess) {
        int index = 0;
        for(String s: chess) {
            if (s.contains("O")) {
                return  index;
            }
            index++;
        }
        return -1;
    }





    public static void computeIntervals(String[] args) {


        //int[] A= new int[]{2,4,1,6,5,9,7};
        int[] A = new int[]{2,1,6,4,3,7};
        //int[] A = new int[]{4,3,2,6,1};

        int count =0;
        List<Coordinate> list = new ArrayList<>();
        int min = Math.min(A[0], A[1]);
        int max = Math.max(A[0], A[1]);
        list.add(new Coordinate(min, max));
        int maxIndex = 0;

        for (int i=0; i<A.length; i++) {
            Coordinate latest = list.get(maxIndex);
            System.out.println("latest "+ latest.x + " "+ latest.y );

            if (A[i] < latest.x) {

                if (list.size() > 1) {
                    System.out.println("consdering " +  list.get(maxIndex-1).x + "  ,  " + list.get(maxIndex-1).y);
                    System.out.println("consdering " +  A[i] + "  ,  " + latest.y);
                    if (A[i] < list.get(maxIndex-1).x) {
                        Coordinate removedCoord = list.get(maxIndex);
                        list.remove(maxIndex);
                        maxIndex--;
                        list.set(maxIndex, new Coordinate(list.get(maxIndex).x, Math.max(removedCoord.y, list.get(maxIndex).y)));
                    }

                } else {
                    list.set(maxIndex, new Coordinate(A[i], latest.y));
                }

//                int finalMin = list.size() > 1 ? Math.min(A[i], list.get(maxIndex-1).x) : A[i];
//                int finalMax = list.size() > 1 ? Math.max(latest.y, list.get(maxIndex-1).y) : latest.y;



            }

            if (A[i] > latest.y) {
                list.add(new Coordinate(A[i], A[i]));
                maxIndex++;
            }



        }

        for(Coordinate c: list) {
            System.out.println("X " + c.x +" , " + c.y);
        }

    }
}
