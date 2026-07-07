class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
         Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

         int kept=0;

         int i=0;
         while(i<intervals.length){
            int currStart=intervals[i][0];
            int currEnd=intervals[i][1];

            int j=i;

            while(j<intervals.length&&intervals[j][0]<currEnd){
               
                j++;
            }
            kept++;
            i=j;

         }
         return intervals.length-kept;
    }
}