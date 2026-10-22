class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;
        if (totalSum % k != 0) return false;
        int target = totalSum / k;
        Arrays.sort(nums);
        int n = nums.length;
        if (nums[n - 1] > target) return false;
        for (int i = 0; i < n / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[n - 1 - i];
            nums[n - 1 - i] = temp;
        }
        int[] buckets = new int[k];
        return backtrack(nums, 0, buckets, target);
    }
    
    private boolean backtrack(int[] nums, int index, int[] buckets, int target) {
        if (index == nums.length) return true;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] + nums[index] > target) continue;   
            if (i > 0 && buckets[i] == buckets[i - 1]) continue;
            buckets[i] += nums[index];
            if (backtrack(nums, index + 1, buckets, target)) {
                return true;
            }
            buckets[i] -= nums[index];
            if (buckets[i] == 0) break;
        }
        return false;
    }
}