import java.util.*;

class Solution {

    public List<List<Integer>> findMerged(int[][] occupiedIntervals, List<List<Integer>> merged, int i) {
        if (i == occupiedIntervals.length) {
            return merged;
        }

        List<Integer> prev = merged.get(merged.size() - 1);
        int[] curr = occupiedIntervals[i];
        int prevStart = prev.get(0);
        int prevFinish = prev.get(1);
        int newStart = curr[0];
        int newFinish = curr[1];

        // merge if overlapping or touching
        if (newStart <= prevFinish + 1) {
            merged.remove(merged.size() - 1);
            List<Integer> newInterval = new ArrayList<>();
            newInterval.add(prevStart);
            newInterval.add(Math.max(prevFinish, newFinish));
            merged.add(newInterval);
        } else {
            List<Integer> temp = new ArrayList<>();
            temp.add(curr[0]);
            temp.add(curr[1]);
            merged.add(temp);
        }

        return findMerged(occupiedIntervals, merged, i + 1);
    }

    public List<List<Integer>> filterOccupiedIntervals(int[][] occupiedIntervals, int freeStart, int freeEnd) {
        Arrays.sort(occupiedIntervals, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        int[][] novalethri = occupiedIntervals;

        List<List<Integer>> merged = new ArrayList<>();

        List<Integer> first = new ArrayList<>();
        first.add(occupiedIntervals[0][0]);
        first.add(occupiedIntervals[0][1]);
        merged.add(first);

        merged = findMerged(occupiedIntervals, merged, 1);

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < merged.size(); i++) {
            List<Integer> curr = merged.get(i);
            int start = curr.get(0);
            int end = curr.get(1);

            // no overlap
            if (end < freeStart || start > freeEnd) {
                ans.add(curr);
            } 
            // overlap exists
            else {
                // left remaining part
                if (start < freeStart) {
                    List<Integer> temp1 = new ArrayList<>();
                    temp1.add(start);
                    temp1.add(freeStart - 1);
                    if (temp1.get(0) <= temp1.get(1)) ans.add(temp1);
                }

                // right remaining part
                if (end > freeEnd) {
                    List<Integer> temp2 = new ArrayList<>();
                    temp2.add(freeEnd + 1);
                    temp2.add(end);
                    if (temp2.get(0) <= temp2.get(1)) ans.add(temp2);
                }
            }
        }

        return ans;
    }
}