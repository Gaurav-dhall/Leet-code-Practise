class Solution {
    public int findSum(int[] arr){
        int sum=0;
        
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        return sum;
    }
    public int[] findDegrees(int[][] matrix) {
        int [] ans = new int[matrix.length];
        for(int i=0;i<matrix.length;i++){
            ans[i]=findSum(matrix[i]);
        }
        
        return ans;
    }
}