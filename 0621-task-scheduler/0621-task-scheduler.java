import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int leastInterval(char[] tasks, int n) {

        class QueueTask {
            char ch;
            int availableTime;
            int frequency;
            QueueTask(char ch, int availableTime, int frequency) {
                this.ch = ch;
                this.availableTime = availableTime;
                this.frequency = frequency;
            }
        }

        class HeapTask{
            char ch;
            int frequency;
            HeapTask(char ch, int frequency){
                this.ch = ch;
                this.frequency = frequency;
            }
        }

        HashMap<Character, Integer> map = new HashMap<>();
        Queue<QueueTask> queue = new LinkedList<>();
        PriorityQueue<HeapTask> heap = new PriorityQueue<>((a,b) ->
            b.frequency - a.frequency
        );    
        
        int currentTime = 0;

        for(char ch : tasks)
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        for(char ch : map.keySet())
            heap.add(new HeapTask(ch, map.get(ch)));

        while(!heap.isEmpty() || !queue.isEmpty()){
            while(!queue.isEmpty() && queue.peek().availableTime <= currentTime){
                QueueTask peak = queue.poll();
                heap.add(new HeapTask(peak.ch, peak.frequency));
            }
            if(!heap.isEmpty()){
                HeapTask current = heap.poll();
                currentTime++;
                current.frequency--;
                if(current.frequency > 0)
                    queue.add(new QueueTask(current.ch, currentTime + n, current.frequency));
            }

            if(heap.isEmpty() && !queue.isEmpty())
                currentTime = queue.peek().availableTime;
        }

        return currentTime;
    }
}