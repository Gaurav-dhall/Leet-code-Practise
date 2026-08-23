class Solution {
    public boolean sumGame(String num) {
        int len=num.length();
        int half=len/2;
        
        int qLeft=0;
        int qRight=0;
        
       int sumLeft=0;
       int sumRight=0;
       
        for(int i=0;i<half;i++){
            if(num.charAt(i)=='?'){
                qLeft++;
                continue;
            }
            
            sumLeft+=num.charAt(i)-'0';
        }
        
        for(int i=half;i<len;i++){
            if(num.charAt(i)=='?'){
                qRight++;
                continue;
            }
            
            sumRight+=num.charAt(i)-'0';
        }
        
        if((qLeft+qRight)%2!=0){
            return true;
        }
        
        int diff=sumLeft-sumRight;
        int qDiff=qRight-qLeft;
        
        return diff!=9*qDiff/2;
    }
}