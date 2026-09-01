import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String s) {

        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = s.length()-1; i >= 0; i--){
            if(!map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), i);
        }

        int maxEnd = 0;
        int count = 1;
        for(int i = 0; i < s.length(); i++){
            maxEnd = Math.max(maxEnd, map.get(s.charAt(i)));
            if(i == map.get(s.charAt(i)) && i == maxEnd){
                result.add(count);
                count = 0;
            }
            count++;
        }
        return result;
    }
}