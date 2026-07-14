class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        Map<String,Character> hash= new HashMap<>();

        String[] words= s.split(" ");
        if(pattern.length()!=words.length){
            return false;
        }

        for(int i=0;i<words.length;i++){
            if(!hash.containsKey(words[i])){
                for(Character ch:hash.values()){
                    if(ch==pattern.charAt(i)){
                        return false;
                    }
                }
                hash.put(words[i],pattern.charAt(i));
            }
            else{
                if(hash.get(words[i])!=pattern.charAt(i)){
                    return false;
                }
            }
        }

        return true;
    }
}