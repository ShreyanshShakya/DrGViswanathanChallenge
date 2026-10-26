class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int off = 20000;
        int[] dp = new int[40001];
        int best = 0;
        for (int x : arr) {
            int len = dp[x - difference + off] + 1;
            dp[x + off] = len;
            if (len > best) best = len;
        }
        return best;
    }
}