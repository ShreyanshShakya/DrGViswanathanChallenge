class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];
        for(int num : nums){
            int[] nextdp = dp.clone();
            for(int sum : dp){
                int currSum = sum+num;
                int rem = currSum%3;
                nextdp[rem] = Math.max(nextdp[rem], currSum);
            }
            dp = nextdp;
        }
        return dp[0];
    }
}