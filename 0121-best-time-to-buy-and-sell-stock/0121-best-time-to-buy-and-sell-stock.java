class Solution {
    public int maxProfit(int[] prices) {
        int m = prices[0];
        int maxP = 0;
        for(int i=1;i<prices.length;i++){
            int curr = prices[i] - m;
            maxP = Math.max(maxP, curr);
            m = Math.min(m, prices[i]);
        }
        return maxP;
    }
}