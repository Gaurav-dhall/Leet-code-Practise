class Solution {
    public int findInSecond(String time){
        String[] slots=time.split(":");
        int totalSecond=0;
        for(int i=0;i<3;i++){
            if(i==0){
                totalSecond=totalSecond+(Integer.parseInt(slots[i])-'0')*60*60;
            }
            if(i==1){
                totalSecond=totalSecond+(Integer.parseInt(slots[i])-'0')*60;
            }
            if(i==2){
                totalSecond=totalSecond+(Integer.parseInt(slots[i])-'0');
            }
        }

        return totalSecond;
    }
    public int secondsBetweenTimes(String startTime, String endTime) {
        int start=findInSecond(startTime);
        int end=findInSecond(endTime);

        return end-start;
    }
}