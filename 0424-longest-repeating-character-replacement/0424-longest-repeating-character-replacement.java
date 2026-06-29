class Solution {
    public int characterReplacement(String s, int k) {
        int l=0;
        int r=0;

        int n=s.length();

        int maxLen=0;
        int [] hash= new int [26];
        int maxFreq=0;

        while(r<n){
        hash[s.charAt(r)-'A']++;
        maxFreq=Integer.max(maxFreq,hash[s.charAt(r)-'A']);

        while(((r-l+1)-maxFreq)>k){
            hash[s.charAt(l)-'A']--;
            l++;
            maxFreq=0;
            for(int i=0;i<26;i++){
                maxFreq=Integer.max(maxFreq,hash[i]);
            }


        }

        int len=r-l+1;
        maxLen=Integer.max(maxLen,len);
        r++;

        }

        return maxLen;
    }
}