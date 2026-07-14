class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int beauty = 0;
        for(int i=0;i<n;i++){
            int[] freq = new int[26];
            for(int j=i;j<n;j++){
                freq[s.charAt(j) - 'a']++;
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                for(int count : freq){
                    if(count>0){
                        max = Math.max(count,max);
                        min = Math.min(count, min);
                    }    
                }
                beauty += (max - min);
            }
        }
        return beauty;
    }
}