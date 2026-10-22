class Solution {
    public int lastStoneWeightII(int[] stones) {
        int total = 0;
        for(int stone : stones){
            total += stone;
        }
        int target = total/2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for(int stone : stones){
            for(int i=target;i>=stone;i--){
                dp[i] = dp[i] || dp[i-stone];
            }
        }
        int ans = 0;
        for(int i=target;i>=0;i--){
            if(dp[i]){
                ans = i;
                break;
            }
        }
        return total-2*ans;
    }
}