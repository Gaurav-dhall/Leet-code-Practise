class Solution {

    public int f(String word1,String word2,int i,int j,int [][] dp){

        if(i<0){
            return j+1;
        }

        if(j<0){
            return i+1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(word1.charAt(i)==word2.charAt(j)){
            return dp[i][j]= 0+f(word1,word2,i-1,j-1,dp);
        }

        int path1=1+f(word1,word2,i,j-1,dp);//insert
        int path2=1+f(word1,word2,i-1,j,dp);//remove
        int path3=1+f(word1,word2,i-1,j-1,dp);//replace

        return dp[i][j]=Math.min(path1,Math.min(path2,path3));
    }
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int [][] dp= new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        return f(word1,word2,n-1,m-1,dp);
    }
}