import java.util.HashMap;

class Solution {
    public int characterReplacement(String s, int k) {

        HashMap<Character, Integer> map = new HashMap<>();
        int right = 0, left = 0;
        int windowSize = 0, maxFreq = 0, replacements = 0, maxWindow = 0;

        while(right < s.length()){

            if(map.containsKey(s.charAt(right)))
                map.put(s.charAt(right), map.get(s.charAt(right))+1);
            else
                map.put(s.charAt(right), 1);

            windowSize++;
            maxFreq = Math.max(maxFreq, map.get(s.charAt(right)));
            replacements = windowSize - maxFreq;

            if(replacements > k){
                map.put(s.charAt(left), map.get(s.charAt(left))-1);
                left++;
                windowSize--;
            } 

            maxWindow = Math.max(maxWindow, windowSize);
            right++;
        }
        
        return maxWindow;
    }
}