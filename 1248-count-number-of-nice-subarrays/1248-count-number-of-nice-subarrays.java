class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int left = 0, count = 0, oddCount = 0;
        int currentSubCount = 0;
        
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 != 0) {
                oddCount++;
                currentSubCount = 0; 
            }
            while (oddCount == k) {
                currentSubCount++; 
                if (nums[left] % 2 != 0) {
                    oddCount--;
                }
                left++; 
            }
            count += currentSubCount;
        }
        
        return count;
    }
}