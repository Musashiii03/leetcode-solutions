import java.util.HashMap;
import java.util.PriorityQueue;

// Disgusting Question

class Solution {
    public String reorganizeString(String s) {

        // Creating HashMap and maintaining the maxFrequency variable
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFrequency = 0;
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            maxFrequency = Math.max(maxFrequency, map.get(s.charAt(i)));
        }

        // Checking the base case, wether the input string is even possible or not
        if(maxFrequency > (s.length() + 1) / 2)
            return "";

        // Creating a class Node, so that we can save multiple fields in the map
        class Node{
            char s;
            int frequency;
            int timestamp;

            Node(char s, int frequency, int timestamp){
                this.s = s;
                this.frequency = frequency;
                this.timestamp = timestamp;
            }
        }

        // Creating maxHeap with custom comparator, first with max frequency, if clashed then recent timestamp
        PriorityQueue<Node> heap = new PriorityQueue<>((a,b) -> {
            if(a.frequency != b.frequency)
                return b.frequency - a.frequency;
            return a.timestamp - b.timestamp;
        });

        // Filling the maxHeap with initial values
        for(char i : map.keySet())
            heap.add(new Node(i, map.get(i), 0));
        
        // Main logic with creating the result String
        StringBuilder result = new StringBuilder();
        int time = 0;
        while (!heap.isEmpty()) {
            Node first = heap.poll();
            if(!result.isEmpty() && first.s == result.charAt(result.length() - 1)){
                
                Node second = heap.poll();
                result.append(second.s);
                second.frequency--;
                second.timestamp = time++;
                if(second.frequency > 0)
                    heap.add(second);
                heap.add(first);
            } else {
                result.append(first.s);
                first.frequency--;
                first.timestamp = time++;
                if(first.frequency > 0)
                    heap.add(first);
            }
        }
        return result.toString();
    }
}