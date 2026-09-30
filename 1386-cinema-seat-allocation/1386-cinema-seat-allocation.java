class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int count = n * 2;
        int[] keys = new int[32768];
        int[] vals = new int[32768];
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int pos = row & 32767;
            
            while (keys[pos] != 0 && keys[pos] != row) {
                pos = (pos + 1) & 32767;
            }
            
            keys[pos] = row;
            vals[pos] |= (1 << seat[1]);
        }
        for (int mask : vals) {
            if (mask == 0) continue;
            
            if ((mask & 240) == 0) {
                if ((mask & 12) != 0 || (mask & 768) != 0) {
                    count -= 1;
                }
            } else {
                if ((mask & 60) == 0 || (mask & 960) == 0) {
                    count -= 1;
                } else {
                    count -= 2;
                }
            }
        }
        return count;
    }
}