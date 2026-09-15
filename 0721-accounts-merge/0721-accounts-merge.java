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

    public void union(int u,int v){
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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Disjoint dj= new Disjoint(accounts.size());
        Map<String,Integer> hash= new HashMap<>();

        for(int i=0;i<accounts.size();i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String curr= accounts.get(i).get(j);
                if(hash.containsKey(curr)){
                    dj.union(hash.get(curr),i);
                }
                else{
                    hash.put(curr,i);
                }
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for(int i=0;i<accounts.size();i++){
            ans.add(new ArrayList<>());
        }

       for(Map.Entry<String,Integer> entry:hash.entrySet()){
            String mail=entry.getKey();
            int ind=entry.getValue();
            ans.get(dj.findUpar(ind)).add(mail);
            
       }

       for(int i=0;i<ans.size();i++){
        Collections.sort(ans.get(i));
       }

       List<List<String>> ulAns= new ArrayList<>();

       for(int i=0;i<ans.size();i++){
        if(ans.get(i).size()!=0){
            ulAns.add(new ArrayList<>());
            ulAns.get(ulAns.size()-1).add(accounts.get(i).get(0));
            for(int j=0;j<ans.get(i).size();j++){
               ulAns.get(ulAns.size()-1).add(ans.get(i).get(j));
            }
        }
       }

       return ulAns;


    }
}