class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        sort(nums, 0, nums.length);
        int n = nums.length;
        int[] dp = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);
        int maxIdx = 0;
        int maxLen = 1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j] == 0 && dp[i] < dp[j]+1){
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if(dp[i] > maxLen){
                maxLen = dp[i];
                maxIdx = i;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int curr = maxIdx;
        while(curr != -1){
            ans.add(nums[curr]);
            curr = parent[curr];
        }
        return ans;
    }
    void sort(int arr[],int start,int end){
        if(start>=end-1){
            return;
        }
        int mid=(end-start)/2+start;
        sort(arr,start,mid);
        sort(arr,mid,end);
        merge(arr,start,mid,mid,end);
    }
    void merge(int arr[],int start1,int end1,int start2,int end2){
        
        int nums[]=new int[end1-start1+end2-start2];
        int b=0;
        int start=start1;
        int end=end2;

        while(true){
            if(start1==end1){
                for(int a=start2; a<end2; a++){
                    nums[b]=arr[a];
                    b++;
                }
                break;
            }
            else if(start2==end2){
                for(int a=start1; a<end1; a++){
                    nums[b]=arr[a];
                    b++;
                }
                break;
            }
            
            if(arr[start1]<arr[start2]){
                nums[b]=arr[start1];
                start1++;
            }
            else{
                nums[b]=arr[start2];
                start2++;
            }
            b++;
        }
        b=0;
        for(int a=start; a<end; a++){
            arr[a]=nums[b];
            b++;
        }
    }
}