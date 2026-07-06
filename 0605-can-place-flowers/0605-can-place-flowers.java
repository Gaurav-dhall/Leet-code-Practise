class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i=0;
        if(flowerbed.length==1&&n==1){
            if(flowerbed[0]==0){

            return true;
            }
            else{
                return false;
            }
        }
        while(i<flowerbed.length){
            if(n==0){
                return true;
            }

            if(flowerbed[i]==1){
                i++;
                continue;
            }
            else{
                if(i==0){
                    if(flowerbed[i+1]==1){
                        i++;
                        continue;
                    }
                    flowerbed[i]=1;
                    n--;
                    i++;
                    continue;
                }

                else if(i==flowerbed.length-1){
                    if(flowerbed[i-1]==1){
                        i++;
                        continue;
                    }
                    flowerbed[i]=1;
                    n--;
                    
                }
                else{
                     if(flowerbed[i-1]==1||flowerbed[i+1]==1){
                    i++;
                    continue;
                }
                else{
                    flowerbed[i]=1;
                    n--;
                }
                }

               
               
            }

            i++;
        }

        if(n==0){
            return true;
        }

        return false;
    }
}