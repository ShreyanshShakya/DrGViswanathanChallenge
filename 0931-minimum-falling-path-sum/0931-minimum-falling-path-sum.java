class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] prevRow = matrix[0].clone();
        for (int i = 1; i < n; i++) {
            int[] currRow = new int[n];
            for (int j = 0; j < n; j++) {
                int minPrev = prevRow[j];
                if (j > 0) minPrev = Math.min(minPrev, prevRow[j - 1]);
                if (j < n - 1) minPrev = Math.min(minPrev, prevRow[j + 1]);
                
                currRow[j] = matrix[i][j] + minPrev;
            }
            prevRow = currRow;
        }
        int minSum = Integer.MAX_VALUE;
        for (int val : prevRow) {
            minSum = Math.min(minSum, val);
        }
        return minSum;
    }
}