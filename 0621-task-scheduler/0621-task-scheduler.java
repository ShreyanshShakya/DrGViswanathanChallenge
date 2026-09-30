class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int maxFreq = 0;
        for (char c : tasks) {
            freq[c - 'A']++;
            if (freq[c - 'A'] > maxFreq) {
                maxFreq = freq[c - 'A'];
            }
        }
        int maxFreqCount = 0;
        for (int f : freq) {
            if (f == maxFreq) {
                maxFreqCount++;
            }
        }
        int partCount = maxFreq - 1;
        int partLength = n - (maxFreqCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - (maxFreq * maxFreqCount);
        int idles = Math.max(0, emptySlots - availableTasks);
        return tasks.length + idles;
    }
}