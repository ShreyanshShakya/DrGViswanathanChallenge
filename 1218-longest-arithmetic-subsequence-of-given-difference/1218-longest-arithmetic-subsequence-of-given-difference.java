class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        Map<Integer, Integer> dp = new HashMap<>();
        int ans = 0;
        for(int a :arr){
            int prev = dp.getOrDefault(a-difference,0);
            int curr = prev+1;
            dp.put(a,curr);
            ans = Math.max(curr,ans);
        }
        return ans;
    }
}