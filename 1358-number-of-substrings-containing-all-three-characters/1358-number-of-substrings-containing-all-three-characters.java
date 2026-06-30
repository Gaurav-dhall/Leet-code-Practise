class Solution {
    public int numberOfSubstrings(String s) {
        int i=0;
        int j=0;
        int n=s.length();
        int [] hash = new int[3];
        int count=0;

        while(j<n){

            hash[s.charAt(j)-'a']++;
            while(hash[0]!=0&&hash[1]!=0&&hash[2]!=0){
                
                count+=n-j;
                hash[s.charAt(i)-'a']--;
                i++;
            }
            j++;
        }
        return count;
    }
}