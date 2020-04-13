package lintcode.day1;

import java.util.ArrayList;
import java.util.List;

public class Solution {



    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        int [] arr=new int[2];
        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                if(numbers[i]+numbers[j]==target){
                    arr[0]=i;
                    arr[j]=j;
                }
            }
        }
        return arr;

    }

    public void rotateString(char[] str, int offset) {
        // write your code here
        if(offset<0){
            return ;
        }
        int n=offset%str.length;
        for(int i=0;i<=n;i++){
            char temp=str[str.length-1];
            for(int j=str.length-2;j>=0;j--){
                str[j+1]=str[j];
            }
            str[0]=temp;
        }
    }



    public List<Integer> getNarcissisticNumbers(int n) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        int i;
        int j;
        if (n == 1) {
            for (i = 0; i <= 9; i++) {
                list.add(i);
            }
            return list;
        } else if (n == 2) {
            return list;
        } else {
            for (i = (int) Math.pow(10, n - 1); i <= 9 * Math.pow(10, n) - 1; i++) {
                String iString = String.valueOf(i);
                int num = 0;

                for (j = 1; j <= n; j++) {
                    num = num + (int) Math.pow(Integer.valueOf(iString.substring(j - 1, j)), n);
                }
                if (num == i) {
                    list.add(i);
                }
            }
         return list;
        }
        }


    public List<Integer> getNarcissisticNumbers1(int n){
        List<Integer> list = new ArrayList<>();
        if (n == 1) {
            for (int i = 0; i <= 9; i++) {
                list.add(i);
                return list;
            }
            return list;
        } else if (n == 2) {
            return list;
        }
        return list;
    }
}
