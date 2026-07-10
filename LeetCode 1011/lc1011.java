import java.util.*;

class Solution {
    int daysNeeded(int[] weights, int capacity) {
        int days = 1;
        int currentLoad = 0;

        for (int w : weights) {
            if (currentLoad + w > capacity) {
                days++;
                currentLoad = w;
            } else {
                currentLoad += w;
            }
        }
        return days;
    }


    int shipWithinDays(int[] weights, int d) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();

        while (left < right) {
            int mid = left + (right - left) / 2;
            int needed = daysNeeded(weights, mid);

            if (needed <= d) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] weights = {5,4,5,2,3,4,5,6};
        int d = 5;
        Solution sol = new Solution();
        System.out.println(sol.shipWithinDays(weights, d));
    }
}
