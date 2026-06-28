class Solution {
    public boolean findHappy(int n,Map <Integer,Integer> hash){

        if(hash.containsKey(n)){
            return false;
        }

        int original=n;

        
        int sum=0;
        while(n!=0){
            int ld=n%10;
            System.out.println(ld);
            sum+=ld*ld;
            System.out.println(sum);
            n/=10;

            
        }
        System.out.println(sum);
        if(sum==1){
            return true;
        }
        hash.put(original,1);
       return findHappy(sum,hash);
    } 
    public boolean isHappy(int n) {
        Map <Integer,Integer> hash= new HashMap<>();
        Boolean isHappyNo=findHappy(n,hash);
        return isHappyNo;
    }
}