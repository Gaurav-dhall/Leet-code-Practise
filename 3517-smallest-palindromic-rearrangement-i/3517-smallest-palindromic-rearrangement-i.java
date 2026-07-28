class Solution {
    public String smallestPalindrome(String s) {
        int[] hash= new int[26];
        Character extra=null;
        for(char ch:s.toCharArray()){
            hash[ch-'a']++;
        }
        StringBuilder sb= new StringBuilder();

        for(int i=0;i<26;i++){
            if(hash[i]%2==0){
                int n=hash[i];
                int k=n/2;

                while(n!=k){
                    sb.append((char)(i+'a'));
                    n--;
                }
            }
            else{
                int n=hash[i]-1;
                int k=n/2;
                extra=(char)(i+'a');
                while(n!=k){
                    sb.append((char)(i+'a'));
                    n--;
                }
            }
        }

        StringBuilder cpy= new StringBuilder(sb);
        if(extra!=null){

        sb.append(extra);
        }
        sb.append(cpy.reverse().toString());

        return sb.toString();
    }
}