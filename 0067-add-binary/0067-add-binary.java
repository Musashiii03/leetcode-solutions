class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();
        while(i >= 0 && j >= 0){
            char chA = a.charAt(i);
            char chB = b.charAt(j);
            if(chA == '0' && chB == '0'){
                if(carry == 0)
                    result.append("0");
                else
                    result.append("1");
                carry = 0;
            } else if((chA == '0' && chB == '1')  || (chA == '1' && chB == '0')){
                if(carry == 1){
                    result.append("0");
                    carry = 1;
                } else {
                    result.append("1");
                    carry = 0;
                }
            } else {
                if(carry == 1)
                    result.append("1");
                else
                    result.append("0");
                carry = 1;
            }
            i--;
            j--;
        }
        while(i >= 0){
            int sum = (a.charAt(i) - '0') + carry;
            result.append(sum % 2);
            carry = sum / 2;
            i--;
        }
        while(j >= 0){
            int sum = (b.charAt(j) - '0') + carry;
            result.append(sum % 2);
            carry = sum / 2;
            j--;
        }
        
        if(carry == 1)
            result.append("1");    
        
        return result.reverse().toString();   
    }
}