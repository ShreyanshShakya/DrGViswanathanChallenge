class Solution {
    public int findContentChildren(int[] greed, int[] size) {
        Arrays.sort(size);
        Arrays.sort(greed);
        int g = 0;
        int s = 0;
        while(s<size.length && g<greed.length){
            if(size[s] >= greed[g]){
                g++;
            }
            s++;
        }
        return g;
    }
}