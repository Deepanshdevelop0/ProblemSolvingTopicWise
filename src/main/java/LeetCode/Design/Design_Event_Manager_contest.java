package LeetCode.Design;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Design_Event_Manager_contest {

    public static void main(String[] args) {
        // Test Case 1
        int[][] events1 = {{5, 7}, {2, 7}, {9, 4}};
        EventManager em1 = new EventManager(events1);
        System.out.println(em1.pollHighest());        // returns 2
        em1.updatePriority(9, 7);
        System.out.println(em1.pollHighest());        // returns 5
        System.out.println(em1.pollHighest());        // returns 9

        // Test Case 2
        int[][] events2 = {{4, 1}, {7, 2}};
        EventManager em2 = new EventManager(events2);
        System.out.println(em2.pollHighest());        // returns 7
        System.out.println(em2.pollHighest());        // returns 4
        System.out.println(em2.pollHighest());        // returns -1
    }

}


class EventManager {

    private Map<Integer, Integer> map;
    private PriorityQueue<int[]> pq;

    public EventManager(int[][] events) {
        map = new HashMap<>();

        pq = new PriorityQueue<>((a,b) -> {
            if (a[1] != b[1]) return Integer.compare(b[1], a[1]);
            return Integer.compare(a[0], b[0]);
        });

        for (int[] event : events) {
            map.put(event[0], event[1]);
            pq.offer(new int[]{event[0], event[1]});
        }

    }

    public void updatePriority(int eventId, int newPriority) {
        map.put(eventId, newPriority);
        pq.offer(new int[]{eventId, newPriority});
    }

    public int pollHighest() {
        while(!pq.isEmpty()) {
            int[] top = pq.poll();
            int id = top[0], priority = top[1];

            if (map.containsKey(id) && map.get(id) == priority) {
                map.remove(id);
                return id;
            }
        }

        return -1;
    }
}
