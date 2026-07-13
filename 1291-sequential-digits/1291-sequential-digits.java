class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int fd=0;
        int cpyLow=low;
        int count=0;
        List<Integer> ans= new ArrayList<>();

        while(cpyLow>0){
            fd=cpyLow%10;
            cpyLow=cpyLow/10;
            count++;
        }

        if(fd>10-count){
                fd=1;
                count++;
            }

        int num=0;
        while(num<=high){
            int len=count;
            int first=fd;
            while(len>0){
                num=num+first*(int)Math.pow(10,len-1);
                first++;
                len--;
            }
            if(num>=low && num<=high){
                ans.add(num);
            }
            else if(num>high){
                break;
            }
            if(fd>=10-count){
                fd=0;
                count++;
            }
            fd++;
            num=0;

        }

        return ans;
    }
}