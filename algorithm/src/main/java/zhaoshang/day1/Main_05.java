package zhaoshang.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName Main_05
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/3 21:37
 * @Version 1.0
 */
public class Main_05 {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int n=in.nextInt();
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            int count=in.nextInt();
            int sum=0;
            for(int j=0;j<count;j++){
                sum+=in.nextInt();
            }
            list.add(sum);
        }
        for(Integer i:list){
            System.out.println(i);
        }

    }
}
