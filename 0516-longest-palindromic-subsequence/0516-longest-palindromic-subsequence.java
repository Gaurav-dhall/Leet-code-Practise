class Solution {
  
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        int [][] dp= new int[n][n];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                if(i==j){
                    dp[i][j]=1;
                }
            }
        }

        for(int l=n-1;l>=0;l--){
            for(int r=l;r<n;r++){
                if(l>r){
                    break;
                }
                if(l==r){
                    continue;
                }
                if(s.charAt(l)==s.charAt(r)){
             dp[l][r]=2+dp[l+1][r-1];
        }
        else dp[l][r]=Math.max(dp[l+1][r],dp[l][r-1]);
            }
        }
        
        return dp[0][s.length()-1];
    }
}