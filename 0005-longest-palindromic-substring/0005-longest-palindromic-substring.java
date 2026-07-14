class Solution {
    public String longestPalindrome(String s) {
    if(s == null || s.length()<1){
        return "";
    }
    StringBuilder sb = new StringBuilder();
    sb.append('^');
    for(int i=0;i<s.length();i++){
        sb.append('#').append(s.charAt(i));
    }
    sb.append("#$");
    String T = sb.toString();
    int n = T.length();
    int[] p = new int[n];
    int c = 0;
    int r = 0;
    int maxlen = 0;
    int centerindex = 0;
    for(int i=1;i<n-1;i++){
        int imirror = 2*c-i;
        if(r>i){
            p[i] = Math.min(r-i,p[imirror]);
        }else{
            p[i] = 0;
        }
        while(T.charAt(i+1+p[i]) == T.charAt(i-1-p[i])){
            p[i]++;
        }
        if(i+p[i] > r){
            c = i;
            r = i+p[i];
        }
        if(p[i]>maxlen){
            maxlen = p[i];
            centerindex = i;
        }
    }
    int start = (centerindex - maxlen)/2;
    return s.substring(start, start+maxlen);
    }
}