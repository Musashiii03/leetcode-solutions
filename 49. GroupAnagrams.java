import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            int[] arr = new int[26];
            for(char ch : strs[i].toCharArray())
                arr[ch - 'a'] += 1; 
            String s = Arrays.toString(arr);
            if(map.containsKey(s))
                map.get(s).add(strs[i]);
            else {
                ArrayList<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(s, list);
            }
        }
        return new ArrayList<>(map.values());
    }
}