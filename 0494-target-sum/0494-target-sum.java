class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> memo = new HashMap<>();
        return backtrack(nums, target, 0,0, memo);
    }
    private int backtrack(int[] nums, int target, int index, int currSum, Map<String,Integer> memo){
        if(index == nums.length){
            return currSum == target ? 1:0;
        }
        String key = index + "," + currSum;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        int add = backtrack(nums, target, index+1, currSum+nums[index], memo);
        int sub = backtrack(nums, target, index+1, currSum-nums[index], memo);
        int totalWays = add+sub;
        memo.put(key, totalWays);
        return totalWays;
    }
}