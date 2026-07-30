class Solution {
    public int minimumPushes(String word) {
        int unique=0;
        int[] hash = new int[26];
        int minKey=0;


        for(int i=0;i<word.length();i++){
           
                   
            if(hash[word.charAt(i)-'a']==0){
                if(unique<8){
                    hash[word.charAt(i)-'a']=1;
                }
                else if(unique<16){
                    hash[word.charAt(i)-'a']=2;
                }
                else if(unique<24){
                    hash[word.charAt(i)-'a']=3;
                }
                else{
                    hash[word.charAt(i)-'a']=4;
                }

                unique++;
            }

             minKey+=hash[word.charAt(i)-'a'];
             
                
            

        }


       

        return minKey;
    }
}