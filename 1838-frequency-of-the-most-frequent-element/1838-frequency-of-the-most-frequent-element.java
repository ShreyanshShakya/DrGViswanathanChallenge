class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        
        int left = 0;
        long totalSum = 0; 
        int maxFreq = 0;
        
        for (int right = 0; right < nums.length; right++) {
            totalSum += nums[right];
            while ((long) nums[right] * (right - left + 1) - totalSum > k) {
                totalSum -= nums[left];
                left++;
            }
            
            maxFreq = Math.max(maxFreq, right - left + 1);
        }
        
        return maxFreq;
    }
}