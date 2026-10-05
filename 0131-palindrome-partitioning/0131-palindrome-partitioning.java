import java.util.ArrayList;
import java.util.List;

class Solution {
    
    List<List<String>> result = new ArrayList<>();
    List<String> partitions = new ArrayList<>();

    public void backtrack(String s, int i){
        if(i >= s.length()){
            result.add(new ArrayList<>(partitions));
            return;
        }
        for(int j = i; j < s.length(); j++){
            if(isPalindrome(s, i, j)){
                partitions.add(s.substring(i, j + 1));
                backtrack(s, j + 1);
                partitions.removeLast();
            }
        }
    }

    public boolean isPalindrome(String s, int l, int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
    
    public List<List<String>> partition(String s) {
        backtrack(s, 0);
        return result;
    }
}