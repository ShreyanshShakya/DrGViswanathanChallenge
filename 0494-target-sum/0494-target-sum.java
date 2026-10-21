class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return backtrack(nums, target, 0,0);
    }
    private int backtrack(int[] nums, int target, int index, int currSum){
        if(index == nums.length){
            return target == currSum ? 1:0;
        }
        int add = backtrack(nums,target,index+1,currSum+nums[index]);
        int sub = backtrack(nums, target, index+1,currSum - nums[index]);
        return add + sub;
    }
}