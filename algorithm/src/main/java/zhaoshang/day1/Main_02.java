package zhaoshang.day1;

import java.util.Scanner;

/**
 * @ClassName Main
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/3 18:33
 * @Version 1.0
 */
public class Main_02 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            int a=in.nextInt();
            int b=in.nextInt();
            System.out.println(a+b);
        }
    }
}
