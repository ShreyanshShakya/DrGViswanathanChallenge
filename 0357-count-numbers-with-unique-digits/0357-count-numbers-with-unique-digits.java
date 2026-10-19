class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        n = Math.min(n,10);
        int total = 10;
        int length = 9;
        int digit = 9;
        for(int i=2;i<=n;i++){
            length *= digit;
            total += length;
            digit--;
        }
        return total;
    }
}