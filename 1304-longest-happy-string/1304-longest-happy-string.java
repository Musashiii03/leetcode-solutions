import java.util.PriorityQueue;

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        
        class Node{
            char ch;
            int frequency;
            public Node(char ch, int frequency){
                this.ch = ch;
                this.frequency = frequency;
            }
        }

        PriorityQueue<Node> heap = new PriorityQueue<>((heapA, heapB) -> 
            heapB.frequency - heapA.frequency
        );
        StringBuilder result = new StringBuilder();
        int count = 0;

        if(a > 0)
            heap.add(new Node('a', a));
        if(b > 0)
            heap.add(new Node('b', b));
        if(c > 0)
            heap.add(new Node('c', c));

        while(!heap.isEmpty()){
            Node current = heap.poll();

            if(result.isEmpty() || result.charAt(result.length()-1) != current.ch){
                result.append(current.ch);
                current.frequency--;
                count = 1;
                if(current.frequency > 0)
                    heap.add(new Node(current.ch, current.frequency));
            } else if(result.charAt(result.length()-1) == current.ch && count < 2){
                result.append(current.ch);
                current.frequency--;
                count++;
                if(current.frequency > 0)
                    heap.add(new Node(current.ch, current.frequency));
            } else if(!heap.isEmpty() && result.charAt(result.length()-1) == current.ch && count >= 2){
                Node second = heap.poll();
                result.append(second.ch);
                second.frequency--;
                count = 1;
                heap.add(new Node(current.ch, current.frequency));
                if(second.frequency > 0)
                    heap.add(new Node(second.ch, second.frequency));
            }
        }

        return result.toString();
    }
}