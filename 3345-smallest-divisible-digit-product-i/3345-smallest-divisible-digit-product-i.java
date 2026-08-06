class Solution {
    public int smallestNumber(int n, int t) {
       int k=n;
       int len=0;

       while(k>0){
        int ld=k%10;
        if(ld%t==0){
            return n;
        }
        k=k/10;
        len++;
       }

       int last=n%10; 
       int first=n/(int)Math.pow(10,len-1);
       if(len==1){
        first=1;
       }
       int count=0;
      

       while((last*first)%t!=0){
        if(last==10){
            return n+count;
        }
            count++;
            last++;
       }
       return n+count;
    }
}