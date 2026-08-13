class Solution {
    public int maxPower(String s) {
        int maxCount=1;


        int i=0;
        int j=1;

        while(j<s.length()){
            if(s.charAt(i)!=s.charAt(j)){
                i=j;
                j=i+1;
            }
            else{
                maxCount=Math.max(maxCount,j-i+1);
                j++;
            }
        }

        return maxCount;
    

    }
}