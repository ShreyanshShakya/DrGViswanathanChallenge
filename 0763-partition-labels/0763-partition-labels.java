class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] arr = new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i) - 'a'] = i;
        }
        int start = 0;
        int maxEnd = 0;
        for(int i=0;i<s.length();i++){
            maxEnd = Math.max(maxEnd, arr[s.charAt(i) - 'a']);
            if(i == maxEnd){
                res.add(i-start+1);
                start = i+1;
            }
        }
        return res;
    }
}