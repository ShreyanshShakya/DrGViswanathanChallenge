class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] locations = new int[1001];
        for(int[] trip : trips){
            int pass = trip[0];
            int start = trip[1];
            int end  = trip[2];
            locations[start]+=pass;
            locations[end]-=pass;
        }
        for(int l : locations){
            capacity -= l;
            if(capacity < 0){
                return false;
            }
        }
        return true;
    }
}