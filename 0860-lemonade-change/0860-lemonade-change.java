class Solution {
    public boolean lemonadeChange(int[] bills) {
       int five=0;
       int ten=0;
       int twenty=0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                if (five>0) {
                    five--;
                    ten++;
                } else {

                    return false;
                }
            } else {
                if ((five>=1&&ten>=1)||five>=3) {
                    if(five>=1&&ten>=1){
                        five--;
                        ten--;
                        twenty++;
                    }
                    else{
                        five=five-3;
                        twenty++;
                    }
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}