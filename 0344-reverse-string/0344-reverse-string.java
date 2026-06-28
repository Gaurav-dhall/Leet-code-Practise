class Solution {
    public void reverseString(char[] s) {
        int n= s.length;
        int l=0;
        int r=n-1;

        while(l<=r){
            char k=s[l];
            s[l]=s[r];
            s[r]=k;
            l++;
            r--;
        }

        return ;
    }
}