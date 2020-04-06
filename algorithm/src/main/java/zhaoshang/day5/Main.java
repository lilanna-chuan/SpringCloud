package zhaoshang.day5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str=in.next();
        int length=str.length();
        int count=0;
        for(int i=1;i<=length/2;i++){
            String temp=str.substring(0,i);
            if(str.replace(temp,"").equals("")){
                count=i;
            }
        }
        if(count==0){
            System.out.println(false);
        }else {
            System.out.println(str.substring(0,count));
        }
    }
}
