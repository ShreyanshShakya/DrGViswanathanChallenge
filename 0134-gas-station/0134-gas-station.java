class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tG = 0;
        int tC = 0;
        for(int i=0;i<gas.length;i++){
            tG += gas[i];
            tC += cost[i];
        }
        if(tG < tC){
            return -1;
        }
        int currG = 0;
        int start = 0;
        for(int i=0;i<gas.length;i++){
            currG += gas[i] - cost[i];
            if(currG < 0){
                currG = 0;
                start = i+1;
            }
        }
        return start;
    }
}