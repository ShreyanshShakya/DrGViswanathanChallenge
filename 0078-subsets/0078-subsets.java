class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(0,nums,temp, res);
        return res;
    }
    private void backtrack(int start, int[] nums, List<Integer> temp, List<List<Integer>> res){
        res.add(new ArrayList<>(temp));
        for(int i = start;i<nums.length;i++){
            temp.add(nums[i]);
            backtrack(i+1,nums,temp,res);
            temp.remove(temp.size()-1);
        }
    }
}