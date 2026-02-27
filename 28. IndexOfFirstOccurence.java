class Solution {
    public int strStr(String haystack, String needle) {
        int haystackLen = haystack.length();
        int needleLen = needle.length();
        if (needleLen > haystackLen)
            return -1;
        if (needleLen == 0)
            return 0;
        for(int p1 = 0; p1 <= haystackLen - needleLen; p1++){
            int p2 = 0;
            while(p2 < needleLen && haystack.charAt(p1+p2) == needle.charAt(p2)){
                p2++;
            }
            if(p2 == needleLen){
                return p1;
            }
        }
        return -1;
    }
}