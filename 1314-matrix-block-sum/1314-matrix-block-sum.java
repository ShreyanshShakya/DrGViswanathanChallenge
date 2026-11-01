class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int n = mat.length; 
        int m = mat[0].length; 
        int[][] ul = new int[mat.length+1][mat[0].length+1];
        for(int i = 1; i < ul.length; i++){
            for(int j = 1; j < ul[0].length; j++){
                ul[i][j] = ul[i-1][j] + ul[i][j-1] - ul[i-1][j-1] + mat[i-1][j-1];
            }
        }
        int[][] kr = new int[mat.length][mat[0].length];
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                kr[i][j] = ul[Math.min(n, i+1+k)][Math.min(m, j+1+k)] - ul[Math.min(n, i+1+k)][Math.max(0, j-k)] - ul[Math.max(0, i-k)][Math.min(m, j+1+k)] + ul[Math.max(0, i-k)][Math.max(0, j-k)];
            }
        }
        return kr;
    }
}