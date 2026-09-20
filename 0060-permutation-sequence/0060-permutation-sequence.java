class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] fact = new int[n];
        int factorial = 1;
        fact[0] = 1;
        for(int i=1;i<n;i++){
            factorial *= i;
            fact[i] = factorial;
            numbers.add(i);
        }
        numbers.add(n);
        k = k-1;
        StringBuilder sb = new StringBuilder();
        for(int i=n-1;i>=0;i--){
            int index = k/fact[i];
            sb.append(numbers.get(index));
            numbers.remove(index);
            k%=fact[i];
        }
        return sb.toString();
    }
}