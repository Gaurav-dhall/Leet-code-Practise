class Solution {
    public boolean checkDivisibility(int n) {
        int cpy=n;
        int sum =0;
        int prod=1;
        while(cpy>0){
            int ld=cpy%10;
            sum+=ld;
            prod*=ld;
            cpy/=10;
            
        }
        
        return (n%(sum+prod))==0?true:false;
    }
}