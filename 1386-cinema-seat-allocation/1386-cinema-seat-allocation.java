class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] r : reservedSeats){
            int row = r[0];
            int col = r[1];
            map.put(row, map.getOrDefault(row,0)|(1<<col));
        }
        int leftMask = (1<<2) | (1<<3) | (1<<4) | (1<<5);
        int rightMask = (1<<6) | (1<<7) | (1<<8) | (1<<9);
        int middleMask = (1<<4) | (1<<5) | (1<<6) | (1<<7);
        int total = (n - map.size()) *2;
        for(int m : map.values()){
            boolean left = (m & leftMask) == 0;
            boolean right = (m & rightMask) == 0;
            if(left & right){
                total+=2;
            }else if(left || right || (m & middleMask)==0){
                total +=1;
            }
        }
        return total;
    }
}