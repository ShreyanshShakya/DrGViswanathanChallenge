class Solution {
    public long minimumPerimeter(long neededApples) {
        long left = 1;
        long right = 100000;
        while (left < right) {
            long r = (left + right) / 2;
            if (2 * r * (r + 1) * (2 * r + 1) >= neededApples) {
                right = r;
            } else {
                left = r + 1;
            }
        }
        return left * 8;
    }
}
