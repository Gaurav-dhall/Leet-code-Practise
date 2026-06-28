class Solution {
    public int nextNum(int n){
        int sum=0;
        while(n!=0){
            int ld=n%10;
           
            sum+=ld*ld;

            n/=10;

        }
       
        return sum;
    }
    public boolean isHappy(int n) {
        int slow=n;
        int fast=n;

        do{
            slow=nextNum(slow);
            
            fast=nextNum(nextNum(fast));
           

            
        }while(slow!=fast);

        if(slow==1){
            return true;
        }

        return false;
    }
}