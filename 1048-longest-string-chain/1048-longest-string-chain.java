class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b) -> Integer.compare(a.length(), b.length()));
        Map<String, Integer> dp = new HashMap<>();
        int ans = 1;
        for(String word : words){
            int currMax = 1;
            for(int i=0;i<word.length();i++){
                String prev = word.substring(0,i) + word.substring(i+1);
                if(dp.containsKey(prev)){
                    currMax = Math.max(currMax, dp.get(prev)+1);
                }
            }
            dp.put(word, currMax);
            ans = Math.max(ans, currMax);
        }
        return ans;
    }
}