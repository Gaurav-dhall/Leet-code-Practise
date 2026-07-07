class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);

        int kept=0;
        int lastEnd=Integer.MIN_VALUE;

        for(int i=0;i<intervals.length;i++){
            if(intervals[i][0]>=lastEnd){
                kept++;
                lastEnd=intervals[i][1];
            }
        }
        return intervals.length-kept;
    }
}