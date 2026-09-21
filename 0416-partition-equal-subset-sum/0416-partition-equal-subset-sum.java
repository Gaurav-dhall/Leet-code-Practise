class Solution {

   
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length;
        
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }

        if(sum%2==1){
            return false;
        }


        boolean [] prev= new boolean[sum/2+1];
        prev[0]=true;
        if(nums[0]==sum/2){

        return true;
        }

        for(int i=1;i<n;i++){

        boolean[] temp= new boolean[sum/2+1];
        temp[0]=true;
            for(int j=1;j<sum/2+1;j++){
                boolean not=prev[j];
                boolean take=false;
                if(nums[i]<=j){
                    take=prev[j-nums[i]];
                }

                temp[j]=take||not;
            }
            prev=temp;
        }

        return prev[sum/2];

        

       
    }
}