package zhaoshang.day1;

import java.util.Scanner;

/**
 * @ClassName Main
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/3 20:50
 * @Version 1.0
 */
public class Main_04 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(!in.hasNext("0")){
            int n=in.nextInt();
            int sum=0;
            for(int i=0;i<n;i++){
                sum+=in.nextInt();
            }
            System.out.println(sum);
        }

    }
}
