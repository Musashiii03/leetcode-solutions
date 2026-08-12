import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {

    class Node{
        int x;
        int y;
        double distance;
        Node(int x, int y, double distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Node> heap = new PriorityQueue<>((a,b) -> Double.compare(a.distance, b.distance));
        for(int[] i : points){
            double distance = Math.sqrt(Math.pow(0 - i[0], 2) + Math.pow(0 - i[1], 2));
            heap.offer(new Node(i[0], i[1], distance));
        }
        int[][] result = new int[k][2];
        int count = 0;
        while(count < k){
            Node min = heap.poll();
            result[count] = new int[] {min.x, min.y};
            count++;
        }
        return result;
    }
}