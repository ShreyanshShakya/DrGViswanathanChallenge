class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        PriorityQueue<Character> maxheap = new PriorityQueue<>((a,b)-> map.get(b)-map.get(a));
        maxheap.addAll(map.keySet());
        StringBuilder sb = new StringBuilder();
        while(!maxheap.isEmpty()){
            char c =maxheap.poll();
            int count = map.get(c);
            for(int i =0;i<count;i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}