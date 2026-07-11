class Solution {
    public long sumAndMultiply(int n) {
        String s = Integer.toString(n);
        long sum = 0;
        long num = 0;
        for(int i=0;i<s.length();i++){
            int digit = s.charAt(i) - '0';
            if(digit != 0){
                num = (num*10)+digit;
                sum += digit;
            }
        }
        
        return sum*num;
    }
}