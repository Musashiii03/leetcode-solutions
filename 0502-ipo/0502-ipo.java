import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        
        int n = profits.length;
        int[][] projects = new int[n][2];
        for(int i = 0; i < n; i++){
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }
        Arrays.sort(projects, (a,b) -> Integer.compare(a[0], b[0]));

        Queue<int[]> queue = new LinkedList<>();
        for(int[] project : projects)
            queue.offer(project);

        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> b - a);

        while(k > 0){
            while(!queue.isEmpty() && queue.peek()[0] <= w)
                heap.add(queue.poll()[1]);
            if(heap.isEmpty())
                break;
            w += heap.poll();
            k--;
        }

        return w;
    }
}