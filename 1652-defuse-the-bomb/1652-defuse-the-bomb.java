class Solution {
    public int[] decrypt(int[] code, int k) {
        int n= code.length;

        int [] arr= new int [2*n];
        for(int i=0;i<arr.length;i++){
            arr[i]=code[i%n];
        }


        if(k>0){
            int l=0;
            int r=l+k;

            while(r<arr.length){
                if(l==n){
                    break;
                }
                int sum=0;
                for(int i=l+1;i<=r;i++){
                    sum+=arr[i];
                }
                code[l]=sum;
                l++;
                r++;
            }
        }
        else if(k<0){
            int r=2*n-1;
            int l=r+k;
            while(l>=0){
                if(r==n-1){
                    break;
                }
                int sum=0;
                for(int i=l;i<r;i++){
                    sum+=arr[i];
                }
                code[r-n]=sum;
                r--;
                l--;
            }
        }
        else{
            for(int i=0;i<n;i++){
                code[i]=0;
            }
        }

        return code;
    }
}