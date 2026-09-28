class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder(num);
        int i = 0;
        while (k > 0 && sb.length() > 0) {
            while (i < sb.length() - 1 &&
                   sb.charAt(i) <= sb.charAt(i + 1)) {
                i++;
            }
            sb.deleteCharAt(i);
            k--;
            if (i > 0) {
                i--;
            }
        }
        int start = 0;
        while (start < sb.length() && sb.charAt(start) == '0') {
            start++;
        }
        String res = sb.substring(start);
        return res.isEmpty() ? "0" : res;
    }
}