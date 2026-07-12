class Solution {
    public int minimumCost(int[] nums, int k) {
        long count = 0;
        long cpy = k;
        long resource = k;
        long MOD = 1000000007L;

        int[] sovalemrin = nums;

        for (int i = 0; i < sovalemrin.length; i++) {
            if (resource < sovalemrin[i]) {
                long t = (sovalemrin[i] - resource + cpy - 1) / cpy;
                resource += t * cpy;
                count += t;
            }
            resource -= sovalemrin[i];
        }

        long totalCost = (count % MOD) * ((count + 1) % MOD) % MOD;
        totalCost = (totalCost * 500000004L) % MOD;

        return (int) totalCost;
    }
} 