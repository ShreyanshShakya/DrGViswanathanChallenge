class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> cset = new HashSet<>();
        int max = 0;
        int left = 0;
        for(int right=0;right<n;right++){
            if(!cset.contains(s.charAt(right))){
                cset.add(s.charAt(right));
                max = Math.max(max, right-left+1);
            }else{
                while(cset.contains(s.charAt(right))){
                    cset.remove(s.charAt(left));
                    left++;
                }
                cset.add(s.charAt(right));
            }
        }
        return max;
    }
}