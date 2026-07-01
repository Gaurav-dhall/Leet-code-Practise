class Solution {
    public int numberOfSubLessThanEqual(int [] nums,int k){
        int l=0;
        int r=0;
        int countOdd=0;
        int n=nums.length;
        int sub=0;
        while(r<n){
            if(nums[r]%2!=0){
                countOdd++;
            }
            while(countOdd>k){
                if(nums[l]%2!=0){
                    countOdd--;
                }
                l++;
            }

            sub+=r-l+1;
            r++;
        }

        return sub;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        

        return numberOfSubLessThanEqual(nums,k)-numberOfSubLessThanEqual(nums,k-1);
    }
}