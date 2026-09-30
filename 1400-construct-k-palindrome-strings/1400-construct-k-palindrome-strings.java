class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length() < k) return false;
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i) - 'a']++;
        }
        int odd = 0;
        for(int f : freq){
            if(f%2 != 0){
                odd++;
            }
        }
        if(odd>k){
            return false;
        }
        return true;
    }
}