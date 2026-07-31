class Solution {
  public void  findDfs(int[][] image, int sr, int sc,int color,int rows,int cols){
        int curr=image[sr][sc];
        image[sr][sc]=color;
        

        if(sc<cols-1&&image[sr][sc+1]==curr){
            findDfs(image,sr,sc+1,color,rows,cols);
        }

        if(sc>0&&image[sr][sc-1]==curr){
            findDfs(image,sr,sc-1,color,rows,cols);
        }

        if(sr>0&&image[sr-1][sc]==curr){
            findDfs(image,sr-1,sc,color,rows,cols);
        }

        if(sr<rows-1&&image[sr+1][sc]==curr){
            findDfs(image,sr+1,sc,color,rows,cols);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        if(color==image[sr][sc]){
            return image;
        }
        findDfs(image,sr,sc,color,m,n);
        return image;
    }
}