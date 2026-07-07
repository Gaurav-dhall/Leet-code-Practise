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
         int len=findLength(n);
         int sum=0;
        

        while(n>0){
           
            int fd=n/(int)Math.pow(10,len-1);
            if(fd!=0){
                newNum=newNum*10+fd;
                sum+=fd;
            }
            n=n%(int)Math.pow(10,len-1);
            len--;
        }

        

        return (long) newNum*sum;
    }
}