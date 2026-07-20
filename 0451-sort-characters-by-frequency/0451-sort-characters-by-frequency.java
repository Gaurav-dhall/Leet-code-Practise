class Solution {
    public String frequencySort(String s) {
        List<Character> [] bucket=new ArrayList[s.length()+1];
        
        int[] hash= new int[300];
        StringBuilder sb=new StringBuilder();
        
        for(char ch:s.toCharArray()){
            hash[ch]++;
            
        }
        
        for(int i=0;i<hash.length;i++){
            if(bucket[hash[i]]==null){
                bucket[hash[i]]=new ArrayList<>();
            }
            bucket[hash[i]].add((char)i);
        }
        
        for(int i=bucket.length-1;i>0;i--){
            List<Character> curr=bucket[i];
            if(curr!=null){
                for(int j=0;j<curr.size();j++){
                for(int k=1;k<=i;k++) {
                    sb.append(curr.get(j));
                }   
               
            }
            }
            
        }
        
        return sb.toString();
    }
}