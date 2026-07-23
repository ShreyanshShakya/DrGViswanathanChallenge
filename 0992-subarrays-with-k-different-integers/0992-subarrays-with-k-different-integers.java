class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int[] count = new int[nums.length + 1]; 
        int left = 0;
        int res = 0;
        int uniqueElements = 0;
        for (int right = 0; right < nums.length; right++) {
            if (count[nums[right]] == 0) {
                uniqueElements++;
            }
            count[nums[right]]++;
            while (uniqueElements > k) {
                count[nums[left]]--;
                if (count[nums[left]] == 0) {
                    uniqueElements--;
                }
                left++;
            }
            res += right - left + 1;
        }

        return res;
    }
}