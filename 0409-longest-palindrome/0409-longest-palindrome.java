class Solution {
    public int longestPalindrome(String s) {
        int n=s.length();
        int [] hash= new int[300];
        for(int i=0;i<n;i++){
            hash[s.charAt(i)]++;
        }
        int len=0;
        Boolean flag=false;

        for(int i=0;i<300;i++){
            if(hash[i]==1){
                flag=true;
            }
            if(hash[i]>=2){
                if(hash[i]%2==0){
                    len+=hash[i];
                }
                else{
                    flag=true;
                    len=len+hash[i]-1;
                }
            }
        }
        return flag?len+1:len;
    }
}