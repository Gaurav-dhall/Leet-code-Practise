class Solution {
    public int countAsterisks(String s) {
        Boolean isBetween=false;
        int count=0;

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='|'){
                isBetween=!isBetween;

            }
            if(!isBetween&&ch=='*'){
                
                    count++;
                
            }
        }
        return count;
    }
}