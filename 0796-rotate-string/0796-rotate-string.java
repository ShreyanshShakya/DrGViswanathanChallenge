class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        String DoubledString = s + s;
        return DoubledString.contains(goal);
    }
}