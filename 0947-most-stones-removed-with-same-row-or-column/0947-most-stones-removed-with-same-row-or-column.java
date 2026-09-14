class Disjoint{
    List<Integer> parent= new ArrayList<>();
    List<Integer> size= new ArrayList<>();

    Disjoint(int n){
        for(int i=0;i<n;i++){
            parent.add(i);
            size.add(1);
        }
    }

    public int findUpar(int v){
        if(parent.get(v)==v){
            return v;
        }
        parent.set(v,findUpar(parent.get(v)));
        return parent.get(v);
    }

    public void findUnion(int u,int v){
        int uParU=findUpar(u);
        int uParV=findUpar(v);

        if(uParU==uParV){
            return ;
        }

        if(size.get(uParU)<size.get(uParV)){
            size.set(uParV,size.get(uParU)+size.get(uParV));
            parent.set(uParU,uParV);
        }
        else{
            size.set(uParU,size.get(uParU)+size.get(uParV));
            parent.set(uParV,uParU);
        }
    }
}

class Solution {
    public int removeStones(int[][] stones) {
       int [] rows= new int [10001];
         int [] cols= new int [10001];
         Disjoint dj= new Disjoint(stones.length);
         for(int i=0;i<10001;i++){
            rows[i]=-1;
            cols[i]=-1;
         }
        int totalParent=0;
        for(int i=0;i<stones.length;i++){
            int [] newStone=stones[i];
            if(rows[newStone[0]]!=-1){
                dj.findUnion(rows[newStone[0]],i);
            }
           if(cols[newStone[1]]!=-1){
                dj.findUnion(cols[newStone[1]],i);
            }
           
             rows[newStone[0]]=i;
                cols[newStone[1]]=i;

        }

        for(int i=0;i<stones.length;i++){
          totalParent=  dj.parent.get(i)==i?totalParent+1:totalParent;
        }

        return stones.length-totalParent;
    }
}