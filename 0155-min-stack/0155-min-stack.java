class MinStack {
    ArrayList<Integer> arr;
    ArrayList<Integer> mino;

    public MinStack() {
        arr = new ArrayList<>();
        mino = new ArrayList<>();
    }
    
    public void push(int value) {
        arr.add(value);
        if(mino.isEmpty()){
            mino.add(value);
        }else{
            mino.add(Math.min(mino.get(mino.size()-1), value));
        }
    }
    
    public void pop() {
        if(!arr.isEmpty()){
            arr.remove(arr.size()-1);
            mino.remove(mino.size()-1);
        }
    }
    
    public int top() {
        if(arr.isEmpty()){
            return -1;
        }
        return arr.get(arr.size()-1);
    }
    
    public int getMin() {
        if(mino.isEmpty()){
            return -1;
        }
        return mino.get(mino.size()-1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */