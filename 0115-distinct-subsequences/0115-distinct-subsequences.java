class Solution {


    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] prev = new int[m + 1];
        prev[0]=1;

        
        for (int i = 1; i < n + 1; i++) {
            int []temp= new int[m+1];
            temp[0]=1;
            for (int j = 1; j < m + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    int notPick = prev[j];
                    int pick = prev[j - 1];

                    temp[j] = pick + notPick;
                }

                else
                    temp[j] = prev[j];
            }
            prev=temp;
        }
        return prev[m];
    }
}