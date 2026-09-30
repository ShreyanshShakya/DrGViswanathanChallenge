class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int left = 0;
        int right = tokens.length-1;
        int score = 0;
        int maxS = 0;
        while(left <= right){
            if(power >= tokens[left]){
                power -= tokens[left];
                left++;
                score++;
                maxS = Math.max(maxS, score);
            }else if(score>0 && left <right){
                power += tokens[right];
                right--;
                score--;
            }else{
                break;
            }
        }
        return maxS;
    }
}