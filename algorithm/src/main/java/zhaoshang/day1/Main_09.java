package zhaoshang.day1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Main_09
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/3 22:12
 * @Version 1.0
 */
public class Main_09 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        while (in.hasNextLine()){
            String[] array=in.nextLine().split(" ");
            Arrays.sort(array);
            for (int i = 0; i < array.length; i++) {
                if (i == array.length - 1) {
                    System.out.println(array[i]);
                    break;
                }
                System.out.print(array[i] + " ");
            }
        }
    }
}
