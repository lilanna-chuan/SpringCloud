package zhaoshang.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_02 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        List<String > list=new ArrayList<>();
        help(n,n,"",list);
        for(int i=0;i<list.size()-1;i++){
            System.out.print(list.get(i)+",");
        }
        System.out.println(list.get(list.size()-1));
    }

    public static void help(int left,int right,String out,List<String > list){
        if(left<0||right<0||left>right){
            return;
        }
        if(left==0 && right==0){
            list.add(out);
            return;
        }
        help(left-1,right,out+"(",list);
        help(left,right-1,out+")",list);
    }
}
