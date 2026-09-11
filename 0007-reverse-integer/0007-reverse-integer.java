class Solution {
    public int reverse(int x) {
        int rev =0;
        if(x>0){
            while(x>0){
            int last=x%10;

             if(rev<Integer.MIN_VALUE/10 || rev>Integer.MAX_VALUE/10 ){
            return 0;
        }
            rev=rev*10+last;
            x/=10;
        }
        
        }
        else{
            while(x<0){
             int last=x%10;

             if(rev<Integer.MIN_VALUE/10 || rev>Integer.MAX_VALUE/10 ){
            return 0;
        }
            rev=rev*10+last;
            x/=10;
            }
          
        }
        
     
        

        return rev;
    }
}