import java.util.HashSet;

class Solution {
    public int maxVowels(String s, int k) {
        
        int vowelCount = 0;

        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        for(int i = 0; i < k; i++){
            if(vowels.contains(s.charAt(i)))
                vowelCount++;
        }
        int maxVowels = vowelCount;
        
        int i = 0;
        while(k < s.length()){
            if(vowels.contains(s.charAt(i)))
                vowelCount--;
            if(vowels.contains(s.charAt(k)))    
                vowelCount++;
            i++;
            k++;
            maxVowels = Math.max(maxVowels, vowelCount);
        }
        return maxVowels;
    }
}