package day.day7;

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/3 17:02
 * @Version 1.0
 */
public class Solution {


    public int[] twoSum1(int[] numbers, int target) {
        // write your code here
        Arrays.sort(numbers);
        int x=0;
        int y=numbers.length;
        int[] a=new int[2];
        while (x<y){
            if(numbers[x]+numbers[y]<target){
                x++;
            }else if(numbers[x]+numbers[y]>target){
                y--;
            }else if(numbers[x]+numbers[y]==target){
                a[0]=x;
                a[1]=y;
            }
        }
        return a;
    }

    public static int[] twoSum(int[] numbers, int target) {
        // write your code here
        int[] a=new int[2];
        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                if(target==numbers[i]+numbers[j]){
                    a[0]=i;
                    a[1]=j;
                    break;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] num={1,0,-1};
        int tag=1;
        twoSum(num,tag);
    }
}
