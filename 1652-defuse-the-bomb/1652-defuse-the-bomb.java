class Solution {
    public int findSum(int [] arr,int k,int i,int n){
        
        
        int sum=0;
        if(k>0){
            for(int j=1;j<=k;j++){
           sum+= arr[i+j];
        }
        }
        else if(k<0){
            for(int j=n+i-1;j>=n+i+k;j--){
                sum+=arr[j];
            }
            
        }
        else{
            sum=0;
        }
        
        return sum;
    }
    public int[] decrypt(int[] code, int k) {
        int n=code.length;

        int [] arr= new int [2*n];

        for(int i=0;i<arr.length;i++){
            arr[i]=code[i%n];
        }

        if(k>0){
            for(int i=0;i<n;i++){
            code[i]=findSum(arr,k,i,n);
        }
        }
        else if(k<0){
            for(int i=n-1;i>=0;i--){
                code[i]=findSum(arr,k,i,n);
            }
        }
        else{
            for(int i=0;i<n;i++){
                code[i]=findSum(arr,k,i,n);
            }
        }
        

        return code;
    }
}