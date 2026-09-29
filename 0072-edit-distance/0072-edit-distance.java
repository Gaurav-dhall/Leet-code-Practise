class Solution {


    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] prev = new int[m + 1];

        for (int j = 0; j < m + 1; j++) {
            prev[j] = j;
        }

        

        for (int i = 1; i < n + 1; i++) {
            int [] temp= new int[m+1];
            temp[0]=i;
            for (int j = 1; j < m + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    temp[j] = 0 + prev[j - 1];
                } else {
                    int path1 = 1 + temp[j - 1];//insert
                    int path2 = 1 + prev[j];//remove
                    int path3 = 1 + prev[j - 1];//replace

                   temp[j] = Math.min(path1, Math.min(path2, path3));
                }

            }
            prev=temp;
        }

        return prev[m];
    }
}