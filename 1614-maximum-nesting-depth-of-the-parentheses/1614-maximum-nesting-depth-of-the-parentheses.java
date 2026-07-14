class Solution {
    public int maxDepth(String s) {
        Stack<Character> sk = new Stack<>();
        int depth = 0;
        int max = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                sk.push(c);
                depth++;
            }else if(c == ')'){
                sk.pop();
                depth--;
            }
            max = Math.max(max, depth);
        }
        return max;
    }
}