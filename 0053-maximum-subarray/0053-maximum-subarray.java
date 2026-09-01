class Solution {
    public int maxSubArray(int[] nums) {
        int maxS = nums[0];
        int sum = 0;
        for(int num : nums){
            if(sum < 0){
                sum = 0;
            }
            sum = sum+num;
            if(sum>maxS){
                maxS = sum;
            }
        }
        return maxS;
    }
}