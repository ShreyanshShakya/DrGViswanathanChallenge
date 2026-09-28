class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        int maxFreq = 0;
        char maxChar = 'a';
        
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
            if (freq[c - 'a'] > maxFreq) {
                maxFreq = freq[c - 'a'];
                maxChar = c;
            }
        }
        
        if (maxFreq > (s.length() + 1) / 2) {
            return "";
        }
        
        char[] result = new char[s.length()];
        int idx = 0;
        
        while (freq[maxChar - 'a'] > 0) {
            result[idx] = maxChar;
            idx += 2;
            freq[maxChar - 'a']--;
        }
        
        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                if (idx >= result.length) {
                    idx = 1; 
                }
                result[idx] = (char) (i + 'a');
                idx += 2;
                freq[i]--;
            }
        }
        
        return new String(result);
    }
}