class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[] prev = new int[m + 1];

        for (int i1 = 1; i1 < n + 1; i1++) {

            int diagonal = 0;   // dp[i-1][0]

            for (int i2 = 1; i2 < m + 1; i2++) {

                int i = i1 - 1;
                int j = i2 - 1;

                int temp = prev[i2]; // save dp[i-1][i2]

                if (text1.charAt(i) == text2.charAt(j)) {
                    prev[i2] = 1 + diagonal;
                }
                else {
                    prev[i2] = Math.max(prev[i2], prev[i2 - 1]);
                }

                diagonal = temp; // old prev[i2] becomes diagonal for next j
            }
        }

        return prev[m];
    }
}