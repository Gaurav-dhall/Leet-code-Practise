class Solution {
    public boolean isVowel(char ch){
        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'){
            return true;
        }
        return false;
    }
    public String reverseVowels(String s) {
        int l=0;
        int r=s.length()-1;
        StringBuilder sb= new StringBuilder(s);

        while(l<=r){
            char left=s.charAt(l);
            char right=s.charAt(r);

            if(isVowel(left)&&!isVowel(right)){
                r--;
            }
            else if(!isVowel(left)&&isVowel(right)){
                l++;
            }
            else if(!isVowel(left)&&!isVowel(right)){
                l++;
                r--;

            }
            else{
                char k=left;
                 left=right;
                 right=k;

                sb.setCharAt(l,left);
                sb.setCharAt(r,right);
                l++;
                r--;


            }
        }
        return sb.toString();
    }
}