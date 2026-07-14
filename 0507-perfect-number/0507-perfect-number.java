class Solution {
    public boolean checkPerfectNumber(int num) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=1;i<num;i++){
            if(num%i == 0){
                arr.add(i);
            }
        }
        int sum=0;
        for(int a : arr){
            sum+=a;
        }
        return sum == num;
    }
}