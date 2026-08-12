import java.util.PriorityQueue;

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> {
            if(a[0] == b[0])
                return a[1] - b[1];
            else
                return a[0] - b[0];
        });
        
        for(int[] i : trips){
            heap.add(new int[] {i[1], i[0]});
            heap.add(new int[] {i[2], -(i[0])});
        }

        int passengers = 0;
        while(!heap.isEmpty()){
            int[] current = heap.poll();
            passengers += current[1];
            if(passengers > capacity)
                return false;
        }
        return true;
    }
}