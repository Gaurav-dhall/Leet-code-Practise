class Solution {
    public int helper(List<List<Integer>> triangle,int r,int c,List<List<Integer>> dp){

        if(r==0&&c==0){
            return triangle.get(0).get(0);
        }
        if(dp.get(r).get(c)!=-1){
            return dp.get(r).get(c);
        }
        int left=Integer.MAX_VALUE;
        int right=Integer.MAX_VALUE;


        if(c>0){
            left=helper(triangle,r-1,c-1,dp);
        }

        if(c<triangle.get(r).size()-1){
            right= helper(triangle,r-1,c,dp);
        }

        dp.get(r).add(c,triangle.get(r).get(c)+Math.min(left,right));
        return dp.get(r).get(c);
        
       
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int minAns=Integer.MAX_VALUE;
        List<List<Integer>> dp= new ArrayList<>();
        for(int i=0;i<n;i++){
            dp.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<triangle.get(i).size();j++){
                dp.get(i).add(-1);
            }
        }
        for(int i=0;i<triangle.get(n-1).size();i++){
           minAns=Math.min(minAns,helper(triangle,n-1,i,dp)) ;
        }

        return minAns;


    }
}