class Solution {
    public int minimumPushes(String word) {
        int ones=1;
        int twos=1;
        int threes=1;
        int fours=1;
        int[] hash = new int[26];
        int minKey=0;


        for(int i=0;i<word.length();i++){
            if(hash[word.charAt(i)-'a']!=0){
                    minKey+=hash[word.charAt(i)-'a'];
                    continue;
                }
            if(ones<=8&&hash[word.charAt(i)-'a']==0){
                
                hash[word.charAt(i)-'a']=1;
                minKey+=hash[word.charAt(i)-'a'];
                ones++;
            }
            if(twos<=8&&hash[word.charAt(i)-'a']==0){
                hash[word.charAt(i)-'a']=2;
                minKey+=hash[word.charAt(i)-'a'];
                twos++;
            }
            if(threes<=8&&hash[word.charAt(i)-'a']==0){
                hash[word.charAt(i)-'a']=3;
                minKey+=hash[word.charAt(i)-'a'];
                threes++;
            }
            if(fours<=8&&hash[word.charAt(i)-'a']==0){
                hash[word.charAt(i)-'a']=4;
                minKey+=hash[word.charAt(i)-'a'];
                fours++;
            }
            

        }


       

        return minKey;
    }
}