class Solution {
    public int countCommas(int n) {
        int num=n;
        int len=0;


        while(num>0){
            len++;
            num=num/10;
        }

        if(len<4){
            return 0;
        }

        return n-999;
    }
}