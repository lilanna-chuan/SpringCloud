package day.day6;

/**
 * @ClassName Solution
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/3 17:02
 * @Version 1.0
 */
public class Solution {

    public static void main(String[] args) {
        int[] A={1,1,2,2,4,4,5,6,7,6,7,100,-1,-2,-1,100,3,-2,3};
        System.out.println(singleNumber(A));

    }
    public static int singleNumber(int[] A) {
        // write your code here
        if(A.length<=0){
            return 0;
        }
        for(int i=0;i<A.length;i++){
            int count=0;
            for(int j=0;j<A.length;j++){
                if(A[i]==A[j]){
                    count++;
                }
            }
            if(count==1){
                return A[i];
            }
        }
        return 0;
    }
}
