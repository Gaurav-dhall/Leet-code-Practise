class Solution {
    public int f(String word1,String word2,int i1,int i2,int [][] dp){

        if(i1<0||i2<0){
            return 0;
        }
        if(dp[i1][i2]!=-1){
            return dp[i1][i2];
        }
        if(word1.charAt(i1)==word2.charAt(i2)){
            return dp[i1][i2]=1+f(word1,word2,i1-1,i2-1,dp);
        }

        return dp[i1][i2]=Math.max(f(word1,word2,i1-1,i2,dp),f(word1,word2,i1,i2-1,dp));
    }
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int [][] dp= new int [n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }

        int sub=f(word1,word2,n-1,m-1,dp);
        return (m-sub)+(n-sub);
    }
}