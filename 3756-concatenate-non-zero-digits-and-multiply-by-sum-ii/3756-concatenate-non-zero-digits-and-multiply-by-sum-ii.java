class Solution {
    int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        long[] prefConcat = new long[n + 1];
        int[] prefCount = new int[n + 1];
        int[] prefSum = new int[n + 1];
        long[] pow10 = new long[n + 1];

        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        for (int i = 0; i < n; i++) {

            // Copy previous prefix values first
            prefSum[i + 1] = prefSum[i];
            prefCount[i + 1] = prefCount[i];
            prefConcat[i + 1] = prefConcat[i];

            int dig = s.charAt(i) - '0';

            if (dig != 0) {
                prefSum[i + 1] += dig;
                prefCount[i + 1]++;
                prefConcat[i + 1] = (prefConcat[i] * 10 + dig) % MOD;
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];

            int sum = prefSum[r + 1] - prefSum[l];

            int cnt = prefCount[r + 1] - prefCount[l];

            long concat =
                    (prefConcat[r + 1]
                    - (prefConcat[l] * pow10[cnt]) % MOD
                    + MOD) % MOD;

            ans[i] = (int)((concat * sum) % MOD);
        }

        return ans;
    }
}