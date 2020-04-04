package zhaoshang.day1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Main_08
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/3 21:59
 * @Version 1.0
 */
public class Main_08 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        String[] array=new String[n];
        for(int i=0;i<n;i++){
            array[i]=in.next();
        }
        Arrays.sort(array);
        for(String str:array){
            System.out.print(str+" ");
        }
        System.out.println();
    }
}
