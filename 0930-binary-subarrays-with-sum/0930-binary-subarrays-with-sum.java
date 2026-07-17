import java.util.HashMap;

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        int currentSum = 0;

        HashMap<Integer, Integer> prefixMap = new HashMap<>();
        
        prefixMap.put(0, 1);
        
        for (int num : nums) {
            currentSum += num; 
            
            int target = currentSum - goal;
            
            if (prefixMap.containsKey(target)) {
                count += prefixMap.get(target);
            }
            
            prefixMap.put(currentSum, prefixMap.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }
}