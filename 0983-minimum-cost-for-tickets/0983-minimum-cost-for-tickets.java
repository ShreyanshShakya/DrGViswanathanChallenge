class Solution {
    public int mincostTickets(int[] days, int[] cost) {
        int n = days.length;
        int lastDay = days[n-1];
        Set<Integer> travelDays = new HashSet<>();
        for(int day : days){
            travelDays.add(day);
        }
        int[] dp = new int[lastDay+1];
        for(int i=1;i<=lastDay;i++){
            if(!travelDays.contains(i)){
                dp[i] = dp[i-1];
                continue;
            }
            int option1 = dp[i-1] + cost[0];
            int option2 = dp[Math.max(0,i-7)] + cost[1];
            int option3 = dp[Math.max(0,i-30)] + cost[2];
            dp[i] = Math.min(option1, Math.min(option2, option3));
        }
        return dp[lastDay];
    }
}