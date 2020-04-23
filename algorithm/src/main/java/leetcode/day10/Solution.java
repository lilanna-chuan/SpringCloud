package leetcode.day10;

import java.util.Scanner;

/**
 * @ClassName Solution
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/23 8:16
 * @Version 1.0
 */
public class Solution {


    /**
     * 面试题 08.11. 硬币
     * @param n
     * @return
     */
    public int waysToChange(int n) {
        int[] values={1,5,10,25};
        int[] dp=new int[n+1];
        dp[0]=1;
        int mod=1000000007;
        for(int i=0;i<values.length;i++){
            for(int j=values[i];j<=n;j++){
                dp[j]=(dp[j]+dp[j-values[i]])%mod;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Solution solution=new Solution();
        while(scanner.hasNext()){
            int n=scanner.nextInt();
            System.out.println(solution.waysToChange(n));
        }
    }
}
