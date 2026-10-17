class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums.length ==0 || nums == null) return 0;
        int maxV = 0;
        for(int num : nums){
            if(num > maxV) maxV = num;
        }
        int[] points = new int[maxV+1];
        for(int num : nums){
            points[num] += num;
        }
        int p1 = 0;
        int p2 = 0;
        for(int v =0;v<=maxV;v++){
            int curr = Math.max(p1, points[v]+p2);
            p2 = p1;
            p1 = curr;
        }
        return p1;
    }
}