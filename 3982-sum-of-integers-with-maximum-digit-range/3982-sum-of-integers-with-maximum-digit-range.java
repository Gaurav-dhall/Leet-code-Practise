class Solution {
    public int maxDigitRange(int[] nums) {
        int n=nums.length;
        int maxRange=0;
        int [] hash= new int[100];

        for(int i=0;i<n;i++){
            int curr=nums[i];
            int maxVal=Integer.MIN_VALUE;
            int minVal=Integer.MAX_VALUE;
            
            
            while(curr>0){
                int ld=curr%10;

                maxVal=Integer.max(ld,maxVal);
                minVal=Integer.min(ld,minVal);
                curr/=10;
                
            }
            int range=maxVal-minVal;
            if(range>=maxRange){
                hash[i]=range;
                maxRange=range;
            }
            
        }
        int sum=0;

        if(maxRange==0){
               int k=0;
            while(k<=n){
                if(k==n) return sum;
                sum+=nums[k];
                k++;
            }
            }

        for(int i=0;i<100;i++){
            
            if(hash[i]==maxRange){
                sum+=nums[i];
            }
        }

        return sum;

        

        
    }
}