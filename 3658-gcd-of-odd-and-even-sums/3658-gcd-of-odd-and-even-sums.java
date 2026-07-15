class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd=(int)Math.pow(n,2);
        int sumEven=(n+1)*n;
       
        int a=sumOdd>sumEven?sumOdd:sumEven;
        int b=a==sumOdd?sumEven:sumOdd;

        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }

        return a;

       
    }
}