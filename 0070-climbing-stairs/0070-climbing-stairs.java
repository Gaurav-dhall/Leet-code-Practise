class Solution {
    public int climbStairs(int n) {
        int [] dp= new int[n+1];
        int nextOfNext=1;
        int next=1;
        for(int i=n-2;i>=0;i--){
            int curr=next+nextOfNext;
            nextOfNext=next;
            next=curr;
        }

        return next;
    }
}