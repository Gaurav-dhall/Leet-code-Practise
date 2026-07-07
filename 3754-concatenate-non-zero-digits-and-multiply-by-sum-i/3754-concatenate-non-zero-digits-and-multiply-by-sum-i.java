class Solution {
    public int findLength(int n){
        int x=n;
        int length=0;

        while(x>0){
            x=x/10;
            length++;
        }
        return length;
    }
    public long sumAndMultiply(int n) {
        int newNum=0;
        

        while(n>0){
            int fd=n/(int)Math.pow(10,findLength(n)-1);
            if(fd!=0){
                newNum=newNum*10+fd;
            }
            n=n%(int)Math.pow(10,findLength(n)-1);
        }

        int x=newNum;
        int sum=0;
        while(x>0){
            int ld=x%10;
            sum+=ld;
            x=x/10;
        }

        return (long) newNum*sum;
    }
}