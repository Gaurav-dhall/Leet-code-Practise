class Solution {
    public int f(int l,int r,String s,int [][] dp){
        if(l>r){
            return 0;
        }
        if(l==r){
            return 0;
        }

        if(dp[l][r]!=-1){
            return dp[l][r];
        }
        if(s.charAt(l)==s.charAt(r)){
            return dp[l][r]= 0+f(l+1,r-1,s,dp);
        }

        return dp[l][r]= 1+Math.min(f(l+1,r,s,dp),f(l,r-1,s,dp));
    }
    public int minInsertions(String s) {
        int n=s.length();
        int [][] dp= new int [n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return f(0,n-1,s,dp);
    }
}