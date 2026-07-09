class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.contains(needle)){
            int l=0;
            int r=0;
            int i=-1;
            
            while(l<haystack.length()){
                if(haystack.charAt(l)!=needle.charAt(r)){
                    l++;
                    r=0;
                    i=-1;
                    continue ;
                }
                
                else{
                    i=l;
                    while(l<haystack.length()&&haystack.charAt(l)==needle.charAt(r)){
                        l++;
                        r++;
                        if(r==needle.length()){
                            return i;
                        }
                    }
                    l=i+1;
                    i=-1;
                    r=0;
                }
            }
        }
        return -1;
        
    }
}