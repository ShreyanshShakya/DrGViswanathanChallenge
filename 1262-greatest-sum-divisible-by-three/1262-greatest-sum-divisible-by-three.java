class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int r = sum % 3;
        if (r == 0) return sum;
        Arrays.sort(nums);
        int smallestRem1_1 = -1, smallestRem1_2 = -1;
        int smallestRem2_1 = -1, smallestRem2_2 = -1;
        for (int num : nums) {
            int rem = num % 3;
            if (rem == 1) {
                if (smallestRem1_1 == -1) smallestRem1_1 = num;
                else if (smallestRem1_2 == -1) smallestRem1_2 = num;
            } else if (rem == 2) {
                if (smallestRem2_1 == -1) smallestRem2_1 = num;
                else if (smallestRem2_2 == -1) smallestRem2_2 = num;
            }
        }
        int ans = 0;
        if (r == 1) {
            if (smallestRem1_1 != -1) {
                ans = Math.max(ans, sum - smallestRem1_1);
            }
            if (smallestRem2_1 != -1 && smallestRem2_2 != -1) {
                ans = Math.max(ans, sum - smallestRem2_1 - smallestRem2_2);
            }
        } else if (r == 2) {
            if (smallestRem2_1 != -1) {
                ans = Math.max(ans, sum - smallestRem2_1);
            }
            if (smallestRem1_1 != -1 && smallestRem1_2 != -1) {
                ans = Math.max(ans, sum - smallestRem1_1 - smallestRem1_2);
            }
        }
        return ans;
    }
}