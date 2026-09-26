class Solution {
    
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int [] prev= new int [m+1];
        
        for(int i1=1;i1<n+1;i1++){
            int [] temp = new int[m+1];
            for(int i2=1;i2<m+1;i2++){
                if(word1.charAt(i1-1)==word2.charAt(i2-1)){
            temp[i2]=1+prev[i2-1];
        }

       else temp[i2]=Math.max(prev[i2],temp[i2-1]);
            }
            prev=temp;
        }

        int sub=prev[m];
        return (m-sub)+(n-sub);
    }
}