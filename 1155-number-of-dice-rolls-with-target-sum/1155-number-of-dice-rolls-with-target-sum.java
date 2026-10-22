class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int MOD = 1000000007;
        if(n<1 || target > n*k){
            return 0;
        }
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i=1;i<=n;i++){
            int[] nextdp = new int[target+1];
            for(int j=i;j<=Math.min(target, i*k);j++){
                for(int v=1;v<=Math.min(k,j);v++){
                    nextdp[j] = (nextdp[j] + dp[j-v]) % MOD;
                }
            }
            dp = nextdp;
        }
        return dp[target];
    }
}