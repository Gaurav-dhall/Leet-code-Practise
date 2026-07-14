class Solution {
    public boolean wordPattern(String pattern, String s) {
        String [] hash= new String [26];
        String [] words= s.split(" ");
        if(pattern.length()!=words.length){
            return false;
        }
        int count=0;
        System.out.print(Arrays.toString(words));
        for (char ch:pattern.toCharArray()){
            int i=ch-'a';
            
            if(hash[i]==null){
                for(int j=0;j<26;j++){
                    if(hash[j]!=null&&hash[j].equals(words[count])){
                        return false;
                    }

                }
                hash[i]=words[count];
            }
            else{
                if(!hash[i].equals(words[count])){
                    return false;
                }
               
            }
            count++;
        }

        return true;

    }
}