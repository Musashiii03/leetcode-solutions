import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int[] getOrder(int[][] tasks) {

        class Node{
            int enqueueTime;
            int processingTime; 
            int index;

            Node(int enqueueTime, int processingTime, int index){
                this.enqueueTime = enqueueTime;
                this.processingTime = processingTime;
                this.index = index;
            }
        }

        int[][] sortedTasks = new int[tasks.length][2];
        for(int i  = 0; i < tasks.length; i++){
            sortedTasks[i][0] = tasks[i][0];
            sortedTasks[i][1] = i;
        }
        Arrays.sort(sortedTasks, (a,b) -> {
            return Integer.compare(a[0], b[0]);
        });

        int[] result = new int[tasks.length];
        int resultIndex = 0;
        int i = 0;
        int currentTime = 0;
        PriorityQueue<Node> heap = new PriorityQueue<>((a,b) -> {
            if(a.processingTime == b.processingTime){
                return a.index - b.index;
            }
            return a.processingTime - b.processingTime;
        });

        while(!heap.isEmpty() || i < tasks.length){
            while(i < tasks.length && sortedTasks[i][0] <= currentTime){
                int originalIndex = sortedTasks[i][1];
                heap.add(new Node(tasks[originalIndex][0], tasks[originalIndex][1], originalIndex));
                i++;
            }
            if(heap.isEmpty())
                currentTime = sortedTasks[i][0];
            if(!heap.isEmpty()){
                Node current = heap.poll();
                result[resultIndex] = current.index;
                resultIndex++;
                currentTime += current.processingTime;
            }
        }

        return result;
    }
}