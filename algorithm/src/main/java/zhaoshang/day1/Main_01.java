package zhaoshang.day1;

import java.util.Scanner;

/**
 * @ClassName Main
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/3 18:30
 * @Version 1.0
 */
public class Main_01 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while (in.hasNext()){
            int a=in.nextInt();
            int b=in.nextInt();
            System.out.println(a+b);
        }
    }

    public static void main2(String[] args) {
        Scanner in=new Scanner(System.in);
        while (in.hasNext()){
            Long a=in.nextLong();
            long b=in.nextLong();
            System.out.println(a+b);
        }
    }
}
