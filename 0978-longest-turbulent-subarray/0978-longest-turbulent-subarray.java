class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        if (n == 1) return 1;
        int left = 0;
        int maxLen = 1;
        int prevCompare = 0; 
        for (int right = 1; right < n; right++) {
            int curCompare = Integer.compare(arr[right - 1], arr[right]);
            if (curCompare == 0) {
                left = right;
            } else if (prevCompare != 0 && curCompare == -prevCompare) {
            } else {
                left = right - 1;
            }
            
            maxLen = Math.max(maxLen, right - left + 1);
            prevCompare = curCompare;
        }
        
        return maxLen;
    }
}