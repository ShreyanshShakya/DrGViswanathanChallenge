class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;
        for(int num : nums){
            high = Math.max(num, high);
        }
        int ans = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(calculateSum(nums, mid) <= threshold){
                ans = mid;
                high = mid-1;
            }else{
                low = mid +1;
            }
        }
        return ans;
    }
    private int calculateSum(int nums[], int divisor){
        int sum = 0;
        for(int num : nums){
            sum += (num +  divisor - 1) / divisor;
        }
        return sum;
    }
}
