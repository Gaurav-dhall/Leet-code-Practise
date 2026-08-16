class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int min=Integer.MAX_VALUE;
        int ind=-1;

        for(int i=0;i<drones.length;i++){
            int[] curr=drones[i];
            int currX=curr[0];
            int currY=curr[1];
            int range=curr[2];

            int manDist=Math.abs(currX-target[0])+Math.abs(currY-target[1]);

            if(manDist<=range&&manDist<min){
                min=Math.min(min,manDist);
                ind=i;
            }
        }

        return ind;
    }
}