package assesment;

import java.util.*;
import static java.util.Arrays.asList;

public class PathAi2 {

    public static void main(String[] args){

        findSlot();

    }

    public static int[] minsStringtoInt(String time){
        String startH=time.substring(0, 2);     //charAt(0)+time.charAt(1)+"";
        String startM=time.substring(3, 5);     //charAt(3)+time.charAt(4)+"";
        String endH=time.substring(6, 8);       //charAt(6)+time.charAt(7)+"";
        String endM=time.substring(9, 11);      //charAt(9)+time.charAt(10)+"";

        int start=((Integer.parseInt(startH)*60)+Integer.parseInt(startM))/15;
        int end=((Integer.parseInt(endH)*60)+Integer.parseInt(endM))/15;
        System.out.println("time:"+time);

        System.out.println(startH+startM+start+" "+endH+endM+end);
        int[] t={start, end};

        return t;
    }

    public static String minsInttoString(int stime, int etime){
        stime=stime*15;
        int hr=stime/60;
        int mi=(stime%60)*(4*15);
        etime=etime*15;
        int hr1=etime/60;
        int mi1=(etime%60)*(4*15);

        StringBuilder sb = new StringBuilder();
        if(hr==0){
            sb.append("00");
        }else if(hr<10){
            sb.append("0");
            sb.append(hr+"");
        }else{
            sb.append(hr+"");
        }

        sb.append(":");

        if(mi==0){
            sb.append("00");
        }else if(mi<10){
            sb.append("0");
            sb.append(mi+"");
        }else{
            sb.append(mi+"");
        }

        sb.append("-");

        if(hr1==0){
            sb.append("00");
        }else if(hr1<10){
            sb.append("0");
            sb.append(hr1+"");
        }else{
            sb.append(hr1+"");
        }

        sb.append(":");

        if(mi1==0){
            sb.append("00");
        }else if(mi1<10){
            sb.append("0");
            sb.append(mi1+"");
        }else{
            sb.append(mi1+"");
        }

        return sb.toString();
    }

    public static List<String> findSlot(){
        int num_slot = 3;
        List<List<String>> schedule_emp = asList(asList("00:00-05:30"), asList("00:00-05:00", "08:00-22:00"), asList("00:00-12:30"));
        List<String> res = new ArrayList<String>();
        int[] frame=new int[96];

        HashMap<Integer,Integer> mapAvail=new HashMap<Integer,Integer>();

        //No employee details updated (Avail=0)
        for(int i=0; i<96; i++){
            if(mapAvail.containsKey(i)==false) mapAvail.put(i,0);
            else {}
            System.out.println("\n i:"+i+" "+ mapAvail.get(i));
        }

        System.out.println("\n********");
        for(int i=0; i<schedule_emp.size(); i++){
            for(int j=0; j<schedule_emp.get(i).size(); j++){
                int[] duration=minsStringtoInt(schedule_emp.get(i).get(j));
                System.out.println(duration[0]+" "+duration[1]);
                for(int k=duration[0]; k<=duration[1];k++){
                    int c=mapAvail.get(k);
                    mapAvail.replace(k,(c+1));
                    System.out.println("\n----k:"+k+" "+ mapAvail.get(k));
                }
            }
        }

        for(int i=0, j=0; i<96; i++, j++){
            frame[i]=mapAvail.get(j);
            System.out.println(frame[i]+" "+i+"===");
        }
        System.out.println("===");

//        for(int i=0, s=num_slot; i<frame.length && s>0; i++){
//            int nemp=0;
//            int nexti=i+1;
//            while(nemp<schedule_emp.size() && s>0){
//                while(i<frame.length-1){
//                    if(frame[i]==nemp){
//                        int start=(15*(i+1));
//                        if(frame[nexti]==nemp){
//                            int end=(15*(nexti+1));
//                            i=nexti;
//                            s--;
//                            String ip=minsInttoString(start,end);
//                            System.out.println(" ip "+ip+"...");
//                            //res[]// storing in results to return:
//                        } else {
//                            int end=(15*(i+1));
//                            s--;
//                            String ip=minsInttoString(start,end);
//                            System.out.println(" ip "+ip+"...");
//                            break;
//                        }
//                    }
//                    nexti++;
//                }
//
//                nemp++;
//            }
//
//
//
//        }
// converstion of result, incomplete:
//        for(int i=0, j=0, k=0; i<schedule_emp.size() && j<num_slot; i++, j++){
//
//            if(mapAvail.containsValue(i)) {
//                k=mapAvail.in
//                int start=mapAvail.get(k);
//                while (mapAvail.get(k) == i) {
//                    k++;
//                }
//                int end = mapAvail.get(k);
//            }
//            for(int g=k+1; g<mapAvail.size(); g++){
//                int start=mapAvail.get(k);
//                int end=mapAvail.get(g);
//                if(start==i){
//
//                }
//
//            }
//
//        }



        return res;
    }







}