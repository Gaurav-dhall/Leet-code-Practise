class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer,Integer> hash= new HashMap<>();
        if(arr.length==0){
            return new int[0];
        }

        int [] cpy= new int[arr.length];

        for(int i=0;i<arr.length;i++){
            cpy[i]=arr[i];
        }

        Arrays.sort(cpy);
        int rank=1;
        hash.put(cpy[0],rank);
        rank++;

        for(int i=1;i<cpy.length;i++){
            if(cpy[i]==cpy[i-1]){
                continue;
            }
            hash.put(cpy[i],rank);
            rank++;
        }
       

        for(int i=0;i<arr.length;i++){
           cpy[i]= hash.get(arr[i]);
        }

        return cpy;
    }
}