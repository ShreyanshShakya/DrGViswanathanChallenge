class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] last = new int[nums.length];
        int size = 0;
        for(int num : nums){
            int left = 0, rigth = size;
            while(left < rigth){
                int mid = left + (rigth - left)/2;
                if(last[mid] < num){
                    left = mid+1;
                }else{
                    rigth = mid;
                }
            }
            last[left] = num;
            if(left == size){
                size++;
            }
        }
        return size;
    }
}