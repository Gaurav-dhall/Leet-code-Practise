class Solution {
   

    public int minInsertions(String s) {
        int n = s.length();
        int[] prev = new int[n];
        for (int l = n - 2; l >= 0; l--) {
            int []  temp=new int [n];
            for (int r = l + 1; r < n; r++) {
                if (s.charAt(l) == s.charAt(r)) {
                   temp[r] = 0 + prev[ r - 1];
                }
                else temp[r] = 1 + Math.min(prev[ r], temp[ r - 1]);
            }
            prev=temp;
        }
        return prev[ n - 1];
    }
}