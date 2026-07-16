class Solution {

    public long findGcd(long a,long b){
        while(b!=0){
            long temp=a;
            a=b;
            b=temp%b;

           
        }

         return a;
    }
    public long gcdSum(int[] nums) {
        
        long max=Integer.MIN_VALUE;
        long[] prefixGcd= new long [nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max=nums[i];
            }

            prefixGcd[i]=findGcd(max,(long)nums[i]);
        }

        Arrays.sort(prefixGcd);

        int l=0;
        int r=prefixGcd.length-1;

        long sum=0;

        while(l<r){
            sum+=findGcd(prefixGcd[r],prefixGcd[l]);
            l++;
            r--;
        }

        return sum;
    }
}