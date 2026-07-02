class Solution {
    public String majorityFrequencyGroup(String s) {
        int [] hash = new int[26];
        int [] size= new int[200];
        StringBuilder ans = new StringBuilder();

        for(char ch:s.toCharArray()){
            hash[ch-'a']++;
        }

        for(int i=0;i<26;i++){
            if(hash[i]!=0){
                 size[hash[i]]++;
            }
           
        }

        int maxDist=Integer.MIN_VALUE;
        int ind=0;

        for(int i=0;i<200;i++){
            if(size[i]>=maxDist){
                maxDist=Integer.max(maxDist,size[i]);
            ind=i;
            }
        }

        for(int i=0;i<26;i++){
            if(hash[i]==ind){
                char ch=(char)('a'+i);
                ans.append(ch);

            }
        }

        return ans.toString();
        
    }
}