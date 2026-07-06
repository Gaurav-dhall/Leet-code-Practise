import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        // Step 1: Sort intervals by starting time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> ans = new ArrayList<>();

        int i = 0;

        while (i < intervals.length) {

            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            // Merge all overlapping intervals
            while (i < intervals.length &&
                   intervals[i][0] <= currEnd) {

                currEnd = Math.max(currEnd, intervals[i][1]);
                i++;
            }

            ans.add(new int[]{currStart, currEnd});
        }

        return ans.toArray(new int[ans.size()][]);
    }
}