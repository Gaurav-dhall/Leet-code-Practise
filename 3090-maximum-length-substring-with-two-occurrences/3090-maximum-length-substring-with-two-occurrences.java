class Solution {
    public int maximumLengthSubstring(String s) {
        int i = 0;
        int j = 0;
        int maxLen = Integer.MIN_VALUE;

        Map<Character, Integer> hash = new HashMap<>();

        while (j < s.length()) {

            if (hash.getOrDefault(s.charAt(j), 0) < 2) {
                hash.put(s.charAt(j),hash.getOrDefault(s.charAt(j), 0) + 1);
                j++;
            } else {
                maxLen = Math.max(maxLen, j - i);
                hash.put(s.charAt(i),hash.get(s.charAt(i)) - 1);
                i++;
            }

        }

        maxLen=Math.max(j-i,maxLen);
        return maxLen;
    }
}