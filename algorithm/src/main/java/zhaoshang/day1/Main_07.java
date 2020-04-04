package zhaoshang.day1;

import java.util.Scanner;

/**
 * @ClassName Main_07
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/3 21:51
 * @Version 1.0
 */
public class Main_07 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while (in.hasNextLine()){
            String[] s=in.nextLine().split(" ");
            int sum=0;
            for(int i=0;i<s.length;i++){
                sum+=Integer.parseInt(s[i]);
            }
            System.out.println(sum);
        }
    }
}
