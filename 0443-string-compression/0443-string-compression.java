class Solution {
    public int compress(char[] chars) {
        int count = 1;
        char prevChar = chars[0];
        int pointer = 0;
        if(chars.length == 1)
            return 1;
        for(int i = 1; i < chars.length; i++){
            if(chars[i] == prevChar){
                count++;
            } else{
                chars[pointer] = prevChar;
                pointer++;
                if(count > 1){
                    String countStr = String.valueOf(count);
                    for(char c : countStr.toCharArray()){
                        chars[pointer++] = c;
                    }
                }
                count = 1;
                prevChar = chars[i];
            }
        }
        chars[pointer] = prevChar;
        pointer++;
        if(count > 1){
            String countStr = String.valueOf(count);    
            for(char c : countStr.toCharArray()){
                chars[pointer++] = c;
            }
        }
        return pointer;       
    }
}