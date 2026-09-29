class Solution {
    public int minSetSize(int[] arr) {
        int n = arr.length/2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int a : arr){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        ArrayList<Integer> list = new ArrayList<>(map.values());
        list.sort(Collections.reverseOrder());
        int setSize = 0;
        int count = 0;
        for(int l : list){
            count+=l;
            setSize++;
            if(count>=n){
                break;
            }
        }
        return setSize;
    }
}