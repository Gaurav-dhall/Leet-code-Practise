class Solution {
    public int arrayPairSum(int[] nums) {
        int min = Integer.MAX_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++){
            min=Math.min(min,nums[i]);
        }

        int [] hash= new int[20003];

        for(int i=0;i<nums.length;i++){
            hash[nums[i]-min]++;
        }

        int i=0;
        for(int j=0;j<hash.length;j++){
           
                while(hash[j]>0){
                    nums[i]=j+min;
                    i++;
                    hash[j]--;
                }
            
        }
        int k=nums.length-2;
        int sum=0;
        while(k>=0){
            sum+=nums[k];
            k=k-2;
        }

        return sum;

    }
}