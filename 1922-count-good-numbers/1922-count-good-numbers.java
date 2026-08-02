class Solution {
    static final int mod = 1000000007;
    public int countGoodNumbers(long n) {
        long even = (n+1)/2;
        long odd = (n/2);
        long ec = pow(5, even);
        long oc = pow(4, odd);
        return (int)((ec*oc)%mod);
    }
    private long pow(long a, long b){
        long r = 1;
        a = a%mod;
        while(b>0){
            if(b%2==1){
                r = (r*a)%mod;
            }
            a = (a*a)%mod;
            b = b/2;
        }
        return r;
    }
}