package zhaoshang.day1;

import java.util.Scanner;

/**
 * @ClassName Main
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/3 20:46
 * @Version 1.0
 */
public class Main_03 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while (true){
            int a=in.nextInt();
            int b=in.nextInt();
            if(a==0 && b==0){
                break;
            }else {
                System.out.println(a+b);
            }
        }
    }
}
