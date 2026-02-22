import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        if (slen != tlen)
            return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < slen; i++){
            if(map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            else
                map.put(s.charAt(i), 1);
        }
        for(int i = 0; i < tlen; i++){
            if(map.containsKey(t.charAt(i)) && map.get(t.charAt(i)) != 0)
                map.put(t.charAt(i), (map.get(t.charAt(i))-1));
            else
                return false;
        }
        return true;
    }
}