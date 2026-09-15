class Disjoint{
    List<Integer> parent= new ArrayList<>();
    List<Integer> size= new ArrayList<>();

    Disjoint(int n){
        for(int i=0;i<n;i++){
            parent.add(i);
            size.add(1);
        }
    }

    public int findUpar(int u){
        if(parent.get(u)==u){
            return u;
        }
        parent.set(u,findUpar(parent.get(u)));
        return parent.get(u);
    }

    public void union(int u , int v){
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
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        Disjoint dj= new Disjoint(n*n);


        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    int x=n*i+j;

                    if(i<grid.length-1&&grid[i+1][j]==1){
                        int y=n*(i+1)+j;
                        dj.union(x,y);
                    }

                    if(i>0&&grid[i-1][j]==1){
                        int y=n*(i-1)+j;
                        dj.union(x,y);
                    }

                    if(j>0&&grid[i][j-1]==1){
                        int y=n*i+j-1;
                        dj.union(x,y);
                    }

                    if(j<grid[i].length-1&&grid[i][j+1]==1){
                        int y=n*i+j+1;
                        dj.union(x,y);
                    }
                }
               
            }
        }

        int maxSize=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    int node=n*i+j;
                    int parent=dj.findUpar(node);

                    maxSize=Math.max(maxSize,dj.size.get(parent));
                }
            }
        }
       

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==0){
                    Set<Integer> choice=new HashSet<>();

                    if(i<grid.length-1&&grid[i+1][j]==1){
                        choice.add(dj.findUpar(n*(i+1)+j));
                    }

                    if(i>0&&grid[i-1][j]==1){
                        int y=n*(i-1)+j;
                        choice.add(dj.findUpar(y));
                    }

                    if(j>0&&grid[i][j-1]==1){
                        int y=n*i+j-1;
                        choice.add(dj.findUpar(y));
                    }

                    if(j<grid[i].length-1&&grid[i][j+1]==1){
                        int y=n*i+j+1;
                        choice.add(dj.findUpar(y));
                    }

                    int size=1;

                    for(int val:choice){
                        size+=dj.size.get(val);
                    }

                    maxSize=Math.max(size,maxSize);
                }
            }
        }

        return maxSize;
    }
}