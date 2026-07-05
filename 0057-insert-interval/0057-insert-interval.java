class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start=newInterval[0];
        Boolean added=false;
        List<int[]> ans= new ArrayList<>();
        int end=newInterval[1];
        int i=0;
        if(intervals.length==0){
            ans.add(newInterval);
            return ans.toArray(new int[ans.size()][]);
        }
        while(i<intervals.length){
            int[] curr=intervals[i];
            int currStart=curr[0];
            int currEnd=curr[1];

            if(currEnd<start){
                ans.add(curr);
                i++;
            }
            else{
                if(start<currStart){
                    if(end<currStart){
                        ans.add(newInterval);
                        ans.add(curr);
                        added=true;
                        i++;
                        break;
                    }
                    else if(end<=currEnd){
                        ans.add(new int[]{start,currEnd});
                        added=true;
                        i++;
                        break;
                    }
                    else{
                         int j=i;
                        while(j<intervals.length&&intervals[j][1]<end){
                            j++;
                        }
                        if(j==intervals.length){
                            ans.add(newInterval);
                            return ans.toArray(new int[ans.size()][]);
                        }
                        if(end<intervals[j][0]){
                            ans.add(newInterval);
                            i=j;
                            added=true;
                            break;
                        }
                        ans.add(new int[]{start,intervals[j][1]});
                        i=j+1;
                        added=true;
                        break;
                    }
                }
                else{
                    if(end<=currEnd){
                        return intervals;
                    }
                    else{
                        int j=i;
                        while(j<intervals.length&&intervals[j][1]<end){
                            j++;
                        }
                        if(j==intervals.length){
                            ans.add(new int[]{currStart,end});
                            return ans.toArray(new int[ans.size()][]);
                        }
                        if(intervals[j][0]>end){
                            ans.add(new int[]{currStart,end});
                            i=j;
                            added=true;
                            break;
                        }
                        else{
                        ans.add(new int[]{currStart,intervals[j][1]});
                        i=j+1;
                        added=true;
                        break;
                        }
                       
                    }
                }
            }


            
        }
 
        if(added){
            while(i<intervals.length){
            ans.add(new int[]{intervals[i][0],intervals[i][1]});
            i++;
        }
        }
        else{
            ans.add(newInterval);

        }
        

        return ans.toArray(new int[ans.size()][]);
    }
}