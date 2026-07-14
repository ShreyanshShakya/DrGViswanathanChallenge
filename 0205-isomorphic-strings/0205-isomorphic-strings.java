class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] sa = new int[256];
        int[] ta = new int[256];

        for(int i=0;i<s.length();i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(sa[c1] != ta[c2]){
                return false;
            }
            sa[c1] = i+1;
            ta[c2] = i+1;
        }
        return true;
    }
}