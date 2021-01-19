class Solution {
    public boolean inside(int[][] image,int r1,int c1,boolean[][] visited,int sr,int sc){
        int r = image.length;
        int c = image[0].length;
        return(r1>=0 && r1<r && c1>=0 && c1<c &&(image[r1][c1]==image[sr][sc] && !visited[r1][c1]));
    }
    public int[][] dfs(int[][] image,int r1,int c1,int newColor,boolean[][] visited,int sr,int sc,int[][]k){
    int r = image.length;
    int c = image[0].length;
    int[] neighbourrow = new int[] {-1,0,1,0};
    int[] neighbourcolumn = new int[] {0,1,0,-1};
    visited[r1][c1] = true;
    for(int m=0;m<4;m++){
        if(inside(image,r1+neighbourrow[m],c1+neighbourcolumn[m],visited,sr,sc)){
            k[r1+neighbourrow[m]][c1+neighbourcolumn[m]]=k[r1][c1];
            dfs(image,r1+neighbourrow[m],c1+neighbourcolumn[m],newColor,visited,sr,sc,k);
        }
    }
    return k;
}
    public int[][] fillcolor(int[][] image,int sr,int sc,int newColor){
        int r = image.length;
        int c = image[0].length;
        int[][] k = new int[r][c];
        for(int m=0;m<r;m++){
            for(int n=0;n<c;n++){
                k[m][n]=image[m][n];
            }
        }
        k[sr][sc]=newColor;
        boolean[][] visited = new boolean[r][c];
        for(int m=sr;m<r;m++){
            for(int n=sc;n<c;n++){
                if(image[m][n]==image[sr][sc] && !visited[m][n]){
                    k=dfs(image,m,n,newColor,visited,sr,sc,k);
                }
            }
        }
        return k;
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] ans = fillcolor(image,sr,sc,newColor);
        return ans;
        
    }
}

