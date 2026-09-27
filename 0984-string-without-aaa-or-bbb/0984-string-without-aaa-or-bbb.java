class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        while (a > 0 || b > 0) {
            int len = sb.length();
            boolean writeA = false;
            if (len >= 2 && sb.charAt(len - 1) == 'a' && sb.charAt(len - 2) == 'a') {
                writeA = false; 
            } else if (len >= 2 && sb.charAt(len - 1) == 'b' && sb.charAt(len - 2) == 'b') {
                writeA = true;  
            } else {
                writeA = (a >= b);
            }
            if (writeA) {
                sb.append('a');
                a--;
            } else {
                sb.append('b');
                b--;
            }
        }
        return sb.toString();
    }
}