class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a,b) -> Integer.compare(a[1], b[1]));
        int ans = 0;
        int temp = Integer.MIN_VALUE;
        for (int[] pair : pairs) {
            if (pair[0] > temp) {
                ans++;
                temp = pair[1]; 
            }
        }
        return ans;
    }
}