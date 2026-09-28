class Solution {
    public int countPalindromes(String s) {

        int MOD = 1_000_000_007;
        int n = s.length();

        long[][] left = new long[10][10];
        long[][] right = new long[10][10];

        long[] leftCount = new long[10];
        long[] rightCount = new long[10];

        // Build all pairs initially on the right
        for (int i = n - 1; i >= 0; i--) {

            int digit = s.charAt(i) - '0';

            for (int b = 0; b < 10; b++) {
                right[digit][b] += rightCount[b];
            }

            rightCount[digit]++;
        }

        long ans = 0;

        // Consider every character as middle
        for (int i = 0; i < n; i++) {

            int digit = s.charAt(i) - '0';

            // Remove current character from right
            rightCount[digit]--;

            // Remove pairs starting with current character
            for (int b = 0; b < 10; b++) {
                right[digit][b] -= rightCount[b];
            }

            // Count a b c b a
            for (int a = 0; a < 10; a++) {
                for (int b = 0; b < 10; b++) {

                    ans += left[a][b] * right[b][a];
                    ans %= MOD;
                }
            }

            // Move current character to left
            for (int a = 0; a < 10; a++) {
                left[a][digit] += leftCount[a];
            }

            leftCount[digit]++;
        }

        return (int) ans;
    }
}