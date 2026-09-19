class Solution {
    public int helper(List<List<Integer>> triangle, int r, int c, List<List<Integer>> dp) {

        return dp.get(r).get(c);

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dp.add(new ArrayList<>());
        }

        dp.get(0).add(triangle.get(0).get(0));
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int left = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;

                if (j > 0) {
                    left = dp.get(i-1).get(j - 1);
                }

                if (j < triangle.get(i).size() - 1) {
                    right = dp.get(i-1).get(j);
                }

                 dp.get(i).add(j,triangle.get(i).get(j)+Math.min(left,right));
            }
        }

        int minAns=Integer.MAX_VALUE;

        for(int i=0;i<dp.get(n-1).size();i++){
            minAns=Math.min(minAns,dp.get(n-1).get(i));
        }

        return minAns;

    }
}