import java.util.ArrayList;
import java.util.List;

class Solution {

    List<String> result = new ArrayList<>();

    public void backtrack(String s, int i){
        if(i == s.length()){
            result.add(s);
            return;
        }
        if(Character.isAlphabetic(s.charAt(i))){
            char[] array = s.toCharArray();
            array[i] = Character.toLowerCase(array[i]);
            String str1 = new String(array);
            backtrack(str1, i + 1);
            array[i] = Character.toUpperCase(array[i]);
            String str2 = new String(array);
            backtrack(str2, i + 1);
        } else
            backtrack(s, i+1);
    }

    public List<String> letterCasePermutation(String s) {
        backtrack(s, 0);
        return result;
    }
}