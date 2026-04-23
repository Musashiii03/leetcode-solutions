/*
import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int len = 0;
        int maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(end < s.length()){
            if(!map.containsKey(s.charAt(end))){
                map.put(s.charAt(end), end);
                len = end - start + 1;
                end++;
            } else {
                start = Math.max(start, map.get(s.charAt(end))+1);
                map.put(s.charAt(end), end);
                end++;
                len = end - start + 1;
            }
            if(len > maxLen)
                maxLen = len;
        }
        return maxLen;
    }
}
*/

import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int len = 0;
        int maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(end < s.length()){
            if(map.containsKey(s.charAt(end)))
                start = Math.max(start, map.get(s.charAt(end))+1);
            map.put(s.charAt(end), end);
            end++;
            len = end - start;
            if(len > maxLen)
                maxLen = len;
        }
        return maxLen;
    }
}