class Solution {
    public void nextPermutation(int[] nums) {
        int right = -1;
        int n = nums.length;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                right = i;
                break;
            }
        }
        if(right ==-1){
            reverse(nums, 0);
            return;
        }
        for(int i=n-1;i>=0;i--){
            if(nums[i]>nums[right]){
                swap(nums,i,right);
                break;
            }
        }
        reverse(nums, right+1);
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int[] nums, int a){
        int left = a;
        int right = nums.length - 1;
        while(left < right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}