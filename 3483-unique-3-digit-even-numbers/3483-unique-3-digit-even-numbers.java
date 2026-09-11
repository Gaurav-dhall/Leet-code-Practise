class Solution {
    public int totalNumbers(int[] digits) {
        int [] hash= new int[10];
        int count=0;

        for(int i=0;i<digits.length;i++){
            hash[digits[i]]++;
        }
        

        for(int i=100;i<=999;i++){
            if(i%2!=0){
                continue;
            }
            int [] nums=new int[10];
           
                int cpy=i;
                while(cpy>0){
                    int ld=cpy%10;
                    nums[ld]++;
                    cpy=cpy/10;
                }
                boolean possible=true;
                for(int j=0;j<10;j++){
                    if(nums[j]>hash[j]){
                        possible=false;
                        break;
                    }
                }

                if(possible){
                    count++;
                }
         
        }

        return count;
    }
}