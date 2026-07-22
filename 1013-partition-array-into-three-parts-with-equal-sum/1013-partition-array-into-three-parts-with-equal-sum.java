class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum=0;

        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }

        if(sum%3!=0){
            return false;
        }

        int partsum=sum/3;
        int checksum=0;
        int count=0;
        for(int i=0;i<arr.length;i++){
            checksum+=arr[i];
            if(checksum==partsum){
                count++;
                checksum=0;
            }
        }

        if(count>=3){
            return true;
        }
        
        return false;
    }
}