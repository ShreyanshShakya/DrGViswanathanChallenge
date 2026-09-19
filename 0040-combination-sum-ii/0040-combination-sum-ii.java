class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0,candidates, target, result, new ArrayList<>());
        return result;
    }
    private void backtrack(int start, int[] candidates, int target, List<List<Integer>> result, List<Integer> temp){
        if(target == 0){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(i>start && candidates[i] == candidates[i-1]) continue;
            if(candidates[i]>target) break;
            temp.add(candidates[i]);
            backtrack(i+1, candidates, target - candidates[i], result, temp);
            temp.remove(temp.size()-1);
        }
    }
}