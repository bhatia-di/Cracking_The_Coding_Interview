package heap;

import java.util.*;
import java.util.Map;

class TrackerFreq {
    int element;
    int freq;

    public TrackerFreq(int element, int freq) {
        this.element = element;
        this.freq = freq;
    }
    public int getElement() {
        return this.element;
    }
    public int getFrequency() {
        return this.freq;
    }
}

public class TopKFrequentElementsLeetcode347 {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> tracker = new HashMap<>();
        // O(N)
        for(int element: nums) {
            tracker.put(element, tracker.getOrDefault(element, 0) +1);

        }

        PriorityQueue<TrackerFreq> pq
                = new PriorityQueue<TrackerFreq>(
                new Comparator<TrackerFreq>() {

                    // Compare method for place element in
                    // reverse order
                    public int compare(TrackerFreq a, TrackerFreq b)
                    {
                        if (a.getFrequency() < b.getFrequency())
                            return -1;
                        if (a.getFrequency() > b.getFrequency())
                            return 1;
                        return 0;
                    }
                });
        // k unique
        // k log k

        for (Map.Entry<Integer, Integer> entry: tracker.entrySet()) {

            if (pq.size() > k) {
                TrackerFreq polled = pq.poll();
                System.out.println("poll " + polled.getElement() + " " + polled.getFrequency());
            }
            else {
                System.out.println("add " + entry.getKey() + " " + entry.getValue());

                pq.add(new TrackerFreq(entry.getKey(), entry.getValue()));
            }

        }

        // o(k)
        int[] output = new int[k];
        int currentIndex =0;
        while(currentIndex <= k-1) {
            output[currentIndex] = pq.poll().getElement();
            currentIndex++;
        }
        return output;


    }

    public static void main(String[] args) {
        int[] in = new int[]{3,0,1,0};
        TopKFrequentElementsLeetcode347 topKFrequentElementsLeetcode347 = new TopKFrequentElementsLeetcode347();
        System.out.println(Arrays.toString(topKFrequentElementsLeetcode347.topKFrequent(in, 1)));
        //[1,1,1,2,2,3]

        int[] in1 = new int[]{1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequentElementsLeetcode347.topKFrequent(in1, 2)));




    }


}
