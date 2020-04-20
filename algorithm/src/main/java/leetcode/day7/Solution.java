package leetcode.day7;

/**
 * @ClassName Solution
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/20 8:31
 * @Version 1.0
 */
public class Solution {


    /**
     * 200. 岛屿数量
     * 深度优先遍历
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if(grid.length<1){
            return 0;
        }
        int count=0;
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    dfs(i,j,n,m,grid);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int i,int j,int n,int m,char[][] grid){
        if(i>=0 &&i<n && j>=0 && j<m && grid[i][j]=='1'){
            grid[i][j]=0;
            dfs(i-1,j,n,m,grid);
            dfs(i+1,j,n,m,grid);
            dfs(i,j-1,n,m,grid);
            dfs(i,j+1,n,m,grid);
        }
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        char[][] grid={{'1'}};
        System.out.println(solution.numIslands(grid));
    }
}
