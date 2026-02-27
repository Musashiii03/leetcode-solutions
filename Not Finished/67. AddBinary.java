class Solution {
    public String addBinary(String a, String b) {
        int aInt = Integer.parseInt(a, 2);
        int bInt = Integer.parseInt(b, 2);
        int sum = aInt + bInt;
        String binary = Integer.toBinaryString(sum);
        return binary;
    }
}