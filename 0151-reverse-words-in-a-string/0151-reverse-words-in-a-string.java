class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        s = s.trim();
        String[] splitted = s.split("\\s+");
        for(int i = splitted.length-1; i >= 0; i--){
            result.append(splitted[i]);
            result.append(' ');
        }
        return result.toString().trim();
    }
}