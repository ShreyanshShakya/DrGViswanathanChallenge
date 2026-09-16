class Solution {
    public int findContentChildren(int[] greed, int[] size) {
        Arrays.sort(size);
        Arrays.sort(greed);
        int res = 0;
        int g = 0;
        for(int s = 0;s<size.length;s++){
            if(g>greed.length-1){
                return res;
            }
            if(greed[g]<=size[s]){
                res++;
                g++;
            }
        }
        return res;
    }
}