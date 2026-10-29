class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) ->{
            if(a[0] == b[0]){
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        int[] tails = new int[envelopes.length];
        int size = 0;
        for(int[] env : envelopes){
            int height = env[1];
            int left = 0, right = size;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tails[mid] < height) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            tails[left] = height;
            if (left == size) {
                size++;
            }
        }
        return size;
    }
}