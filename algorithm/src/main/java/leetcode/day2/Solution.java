package leetcode.day2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Solution
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/15 13:45
 * @Version 1.0
 */
public class Solution {


    /**
     * 542. 01 矩阵
     * 使用广度优先搜索BFS
     * @param matrix
     * @return
     */
    public int[][] updateMatrix(int[][] matrix) {

        if(matrix==null || matrix.length==0){
            return null;
        }
        int n=matrix.length;
        int m=matrix[0].length;
        int [][] arr=new int [n][m];
        boolean[][] flag=new boolean[n][m];
        Queue<int[]> queue=new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    arr[i][j]=0;
                    flag[i][j]=true;
                    queue.offer(new int[]{i,j});
                }
            }
        }

        int[][] direction={{-1,0},{1,0},{0,-1},{0,1}};
        while(!queue.isEmpty()){
            int[] temp=queue.poll();
            int i=temp[0];
            int j=temp[1];
            for(int k=0;k<direction.length;k++){
                int di=i+direction[k][0];
                int dj=j+direction[k][1];
                if(di>=0 && di<n && dj>=0 && dj<m && !flag[di][dj]){
                    arr[di][dj]=arr[i][j]+1;
                    flag[di][dj]=true;
                    queue.offer(new int[]{di,dj});
                }
            }
        }
        return arr;
    }
}
