class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int totalSum = 0;
        int maxNum = 0;
        for (int num : nums) {
            totalSum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (totalSum % k != 0 || maxNum > totalSum / k) {
            return false;
        }
        int target = totalSum / k;
        int n = nums.length;
        int numStates = 1 << n; 
        int[] dp = new int[numStates];
        Arrays.fill(dp, -1);
        dp[0] = 0; 
        for (int mask = 0; mask < numStates; mask++) {
            if (dp[mask] == -1) continue; 
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) == 0) {
                    int currentSubsetSum = dp[mask] % target;
                    if (currentSubsetSum + nums[i] <= target) {
                        int nextMask = mask | (1 << i);
                        dp[nextMask] = dp[mask] + nums[i];
                    }
                }
            }
        }
        return dp[numStates - 1] != -1;
    }
}