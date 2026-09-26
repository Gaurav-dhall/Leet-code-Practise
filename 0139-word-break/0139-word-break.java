class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true; // base case: empty suffix is valid
        
        for (int i = n - 1; i >= 0; i--) {
            for (String word : wordDict) {
                int len = word.length();
                if (i + len <= n && s.substring(i, i + len).equals(word)) {
                    if (dp[i + len]) {
                        dp[i] = true;
                        break; // found a valid word, no need to check more
                    }
                }
            }
        }
        
        return dp[0];
    }
}