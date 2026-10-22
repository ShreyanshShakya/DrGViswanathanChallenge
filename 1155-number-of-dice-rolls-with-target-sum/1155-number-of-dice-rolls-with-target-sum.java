class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int MOD = 1000000007;
        if(n<1 || target > n*k){
            return 0;
        }
        int[][] dp = new int[n+1][target+1];
        dp[0][0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=i;j<=Math.min(target, i*k);j++){
                for(int v=1;v<=Math.min(k,j);v++){
                    dp[i][j] = (dp[i][j] + dp[i-1][j-v]) % MOD;
                }
            }
        }
        return dp[n][target];
    }
}