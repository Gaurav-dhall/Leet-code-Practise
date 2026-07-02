class Solution {
    public String majorityFrequencyGroup(String s) {
        int [] hash = new int[26];
        int [] size= new int[101];
        StringBuilder ans = new StringBuilder();

        for(char ch:s.toCharArray()){
            hash[ch-'a']++;
        }
            int maxDist=Integer.MIN_VALUE;
        int ind=0;
        for(int i=0;i<26;i++){
            if(hash[i]!=0){
                 size[hash[i]]++;
                 if(size[hash[i]]>maxDist){
                    maxDist=Integer.max(maxDist,size[hash[i]]);
            ind=hash[i];
                 }
                 else if(size[hash[i]]==maxDist){
                    if(hash[i]>ind){
                        ind=hash[i];
                    }
                 }
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