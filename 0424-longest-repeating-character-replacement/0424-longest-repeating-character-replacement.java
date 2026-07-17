class Solution {
    public int characterReplacement(String s, int k) {
        int [] freq = new int[26];
        for(int i=0;i<26;i++){
            freq[i] = 0;
        }
        int left = 0, max=0, maxFreq=0;;
        for(int right=0;right<s.length();right++){
            int len = right - left +1;
            char rchar = s.charAt(right);
            freq[rchar-'A']++;
            maxFreq = Math.max(maxFreq, freq[rchar-'A']);
            int replace = len - maxFreq;
            if(replace > k){
                char lchar = s.charAt(left);
                freq[lchar-'A']--;
                left++;
            }
            max = Math.max(max, right-left+1);
        }
        return max;
    }
}