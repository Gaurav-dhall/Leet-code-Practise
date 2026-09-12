class Disjoint{
    List<Integer> parent= new ArrayList<>();
    List<Integer> sizes= new ArrayList<>();

    Disjoint(int n){
        for(int i=0;i<n;i++){
            parent.add(i);
            sizes.add(1);
        }
    }

    public int findUpar(int v){
        if(parent.get(v)==v){
            return v;
        }

       parent.set(v,findUpar(parent.get(v)));
       return parent.get(v);
    }

    public void union(int u, int v){
        int uparU=findUpar(u);
        int uparV=findUpar(v);

        if(uparU==uparV){
            return ;
        }

        if(sizes.get(uparU)<sizes.get(uparV)){
            sizes.set(uparV,sizes.get(uparU)+sizes.get(uparV));
            parent.set(uparU,uparV);
        }
        else{
            sizes.set(uparU,sizes.get(uparU)+sizes.get(uparV));
            parent.set(uparV,uparU);
        }
    }
}


class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1){
            return -1;
        }

        int count=0;
        Disjoint com= new Disjoint(n);

        for(int i=0;i<connections.length;i++){
            com.union(connections[i][0],connections[i][1]);
        }

        for(int i=0;i<n;i++){
           count= com.findUpar(i)==i?count+1:count;
        }

        return count-1;


    }
}