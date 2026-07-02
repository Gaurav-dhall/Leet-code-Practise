class Solution {

    public boolean allZero(Map<Character,Integer> hash){
        for(Character ch:hash.keySet()){
            int count=hash.get(ch);
            if(count>0){
                return false;
            }
        }
        return true;

    }
    public String minWindow(String s, String t) {
        int l=0;
        int r=0;
        int n=s.length();
        Map <Character,Integer> hash= new HashMap<>();
        String ans="";
        int minLen=Integer.MAX_VALUE;
        Boolean allZero=false;


        for(char ch:t.toCharArray()){
            
            hash.put(ch,hash.getOrDefault(ch,0)+1);
        }

        while(r<n){
            if(hash.containsKey(s.charAt(r))){
                hash.put(s.charAt(r),hash.get(s.charAt(r))-1);
                
            allZero=allZero(hash);
            }

            while(allZero){
                if(r-l+1<minLen){
                    minLen=r-l+1;
                    ans=s.substring(l,r+1);
                }
                if(hash.containsKey(s.charAt(l))){
                    hash.put(s.charAt(l),hash.get(s.charAt(l))+1);
                    if(hash.get(s.charAt(l))>0){
                    l++;
                    break;

                    }
                   
                    
                }
                l++;
            }

            allZero=false;
            r++;
        }

        return ans;
    }
}