class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int [] toBeAssigned= new int[arrivalTime.length];

        for(int i=0;i<arrivalTime.length;i++){
            toBeAssigned[i]=arrivalTime[i]%period;
        }

        int maxVal=Integer.MIN_VALUE;

        for(int i=0;i<lights.length;i++){
            maxVal=Math.max(maxVal,lights[i]);
        }

        int maxWaiting=0;

        for(int i=0;i<toBeAssigned.length;i++){
            if(toBeAssigned[i]<maxVal){
                continue;
            }
            maxWaiting=Math.max(maxWaiting,period-toBeAssigned[i]);
            
        }

        return maxWaiting;
    }
}