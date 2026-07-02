class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] ans = new int[m+n];

        int i=0;
        int j=0;
        int index=0;

        while(i<m&&j<n){
            if(nums1[i]<=nums2[j]){
                ans[index]=nums1[i];
                
                i++;
            }
            else{
                ans[index]=nums2[j];
                j++;
            }
            index++;
        }

        while(i<m){
            ans[index]=nums1[i];
            i++;
            index++;
        }

        while(j<n){
            ans[index]=nums2[j];
            j++;
            index++;
        }

        for(int k=0;k<m+n;k++){
            nums1[k]=ans[k];
        }
        
    }
}