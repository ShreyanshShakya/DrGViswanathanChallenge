class Solution {
    public int minCostToMoveChips(int[] position) {
        Map<Integer, Integer> positionCounts = new HashMap<>();
        
        for (int p : position) {
            positionCounts.put(p, positionCounts.getOrDefault(p, 0) + 1);
        }
        
        int evenParityChips = 0;
        int oddParityChips = 0;

        for (Map.Entry<Integer, Integer> entry : positionCounts.entrySet()) {
            int pos = entry.getKey();
            int count = entry.getValue();
            
            if ((pos & 1) == 0) {
                evenParityChips += count;
            } else {
                oddParityChips += count;
            }
        }
        
        return Math.min(evenParityChips, oddParityChips);
    }
}