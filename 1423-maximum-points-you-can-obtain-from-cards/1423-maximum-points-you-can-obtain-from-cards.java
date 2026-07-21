class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int leftsum = 0;
        int maxsum = 0;
        int rightsum=0;
        for(int i=0;i<k;i++){
            leftsum += cardPoints[i];
        }
        maxsum = leftsum;
        int n = cardPoints.length;
        for(int i=0;i<k;i++){
            leftsum -= cardPoints[k-1-i];
            rightsum += cardPoints[n-1-i];
            maxsum = Math.max(maxsum,leftsum+rightsum);
        }
        return maxsum;
    }
}