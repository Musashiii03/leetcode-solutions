class Solution {
    public int lengthOfLastWord(String s) {
        int len = s.length();
        int count = 0;
        for(int i = len-1; i>=0; i--){
            if(s.charAt(i) == ' ' && count == 0)
                continue;
            if(s.charAt(i) == ' '){
                break;
            } else {
                count++;
            }
        }
        return count;
    }
}