package LeetCode.Design;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Design_Event_Manager_contest {

    public static void main(String[] args) {

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

        // int[] arr = events;

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
