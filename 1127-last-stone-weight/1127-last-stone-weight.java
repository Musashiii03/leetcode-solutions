import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> b-a);
        for(int i : stones)
            heap.add(i);
        while(heap.size() > 1){
            int stone1 = heap.poll();
            int stone2 = heap.poll();
            if(stone1 > stone2)
                heap.add(stone1 - stone2);
            else if(stone1 < stone2)
                heap.add(stone2 - stone1);
        }
        return (heap.size() == 0) ? 0 : heap.peek();
    }
}