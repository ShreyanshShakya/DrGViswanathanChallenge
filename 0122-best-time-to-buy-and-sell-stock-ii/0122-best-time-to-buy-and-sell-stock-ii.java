class Solution {
    public int maxProfit(int[] prices) {
        int hold = -prices[0];
        int free = 0;
        for(int i=1;i<prices.length;i++){
            int prevH = hold;
            int prevF = free;
            hold = Math.max(prevH, prevF-prices[i]);
            free = Math.max(prevF, prevH+prices[i]);
        }
        return free;
    }
}