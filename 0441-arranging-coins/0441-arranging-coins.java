class Solution {
    public int arrangeCoins(int n) {
       double l=0;
        double h=n;
        
        while(l<=h){
            double m=Math.floor(l+(h-l)/2);
            
            double total=Math.floor(m*(m+1)/2);
            if(total==n){
                return (int)m;
            }
            
            if(total<n){
                l=m+1;
            }
            else{
                h=m-1;
            }
            
        }
        
        return (int)h;
    }
}