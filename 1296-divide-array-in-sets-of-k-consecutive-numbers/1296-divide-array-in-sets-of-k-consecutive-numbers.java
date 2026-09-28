class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length % k != 0){
            return false;
        }
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        for(int n:nums){
            if(map.get(n)==0){
                continue;
            }
            for(int i=0;i<k;i++){
                int curr = n+i;
                int count = map.getOrDefault(curr,0);
                if(count==0){
                    return false;
                }
                map.put(curr, count-1);
            }
        }
        return true;
    }
}