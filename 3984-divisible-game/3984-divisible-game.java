class Solution {

    public int getMax(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    public int divisibleGame(int[] nums) {

        Set <Integer> kVal= new HashSet<>();
        for(int i=0;i<nums.length;i++){
            int x=nums[i];

            for(int d=2;d*d<=x;d++){
                if(x%d==0){
                    kVal.add(d);
                    kVal.add(x/d);
                }
            }
            if(x>1){

            kVal.add(x);
            }
            if(x==1){
                kVal.add(2);
            }
        }

        int bestDifference = Integer.MIN_VALUE;
        int bestK = 2;

        long MOD = 1000000007L;

        for (int k:kVal) {

            // Create transformed array
            int[] temp = new int[nums.length];

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] % k == 0)
                    temp[i] = nums[i];
                else
                    temp[i] = -nums[i];
            }

            // Kadane's Algorithm
            int l = 0;
            int r = 0;
            int subSum = 0;
            int maxSum = Integer.MIN_VALUE;

            while (r < temp.length) {

                if (subSum + temp[r] > temp[r]) {
                    subSum += temp[r];
                } else {
                    subSum = temp[r];
                    l = r;
                }

                if (subSum > maxSum) {
                    maxSum = subSum;
                }

                r++;
            }

            // Keep smallest k if tie
            if (maxSum > bestDifference) {
                bestDifference = maxSum;
                bestK = k;
            } else if (maxSum == bestDifference && k < bestK) {
                bestK = k;
            }
        }

        long ans = (long) bestDifference * bestK;

        return (int) ((ans % MOD + MOD) % MOD);
    }
}