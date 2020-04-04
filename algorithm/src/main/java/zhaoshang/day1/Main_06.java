package zhaoshang.day1;

import javax.sound.midi.SoundbankResource;
import java.util.Scanner;

/**
 * @ClassName Main_06
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/3 21:47
 * @Version 1.0
 */
public class Main_06 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while (in.hasNext()){
            int n=in.nextInt();
            int sum =0;
            for(int i=0;i<n;i++){
                sum+=in.nextInt();
            }
            System.out.println(sum);
        }
    }
}
