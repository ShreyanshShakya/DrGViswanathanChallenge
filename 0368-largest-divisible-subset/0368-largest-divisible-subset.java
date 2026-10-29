class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if (n == 0) return new ArrayList<>();

        Arrays.sort(nums);

        int[] dp = new int[n];
        int[] parent = new int[n];
        
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        int maxLen = 1;
        int maxIdx = 0;

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] + 1 > dp[i]) {
                    if (nums[i] % nums[j] == 0) {
                        dp[i] = dp[j] + 1;
                        parent[i] = j;
                    }
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIdx = i;
            }
        }

        List<Integer> ans = new ArrayList<>();
        int curr = maxIdx;
        while (curr != -1) {
            ans.add(nums[curr]);
            curr = parent[curr];
        }
        return ans;
    }
}