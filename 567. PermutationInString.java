import java.util.HashMap;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s1.length(); i++){
            if(map.containsKey(s1.charAt(i)))
                map.put(s1.charAt(i), map.get(s1.charAt(i))+1);
            else
                map.put(s1.charAt(i), 1);
        }
        int count = s1.length();
        int left = 0;
        
        for(int right = 0; right < s2.length(); right++){
            if(map.getOrDefault(s2.charAt(right), 0) > 0)
                count--;
            map.put(s2.charAt(right), map.getOrDefault(s2.charAt(right), 0) -1);
            if(right - left + 1 > s1.length()){
                map.put(s2.charAt(left), map.getOrDefault(s2.charAt(left), 0) + 1);
                if(map.get(s2.charAt(left)) > 0)
                    count++;
                left++;
            }    
            if(count == 0)
                return true;
        }
        return false;
    }
}