class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;
        int[][] dp = new int[n][1001];
        int maxLen = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j] + 500; 
                dp[i][diff] = (dp[j][diff] > 0) ? dp[j][diff] + 1 : 2;   
                maxLen = Math.max(maxLen, dp[i][diff]);
            }
        }
        return maxLen;
    }
}