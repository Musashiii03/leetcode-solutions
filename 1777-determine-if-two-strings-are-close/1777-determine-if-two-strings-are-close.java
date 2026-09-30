import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length())
            return false;
        
        HashMap<Character, Integer> map1 = new HashMap<>();
        for(int i = 0; i < word1.length(); i++)
            map1.put(word1.charAt(i), map1.getOrDefault(word1.charAt(i), 0)+1);

        HashMap<Character, Integer> map2 = new HashMap<>();
        for(int i = 0; i < word2.length(); i++)
            map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i), 0)+1);

        List<Character> word1Characters = new ArrayList<>(map1.keySet());
        List<Character> word2Characters = new ArrayList<>(map2.keySet());
        Collections.sort(word1Characters);
        Collections.sort(word2Characters);
        if(!word1Characters.equals(word2Characters))
            return false;

        List<Integer> word1Frequency = new ArrayList<>(map1.values());
        List<Integer> word2Frequency = new ArrayList<>(map2.values());
        Collections.sort(word1Frequency);
        Collections.sort(word2Frequency);
        if(!word1Frequency.equals(word2Frequency))
            return false;
        return true;
    }
}