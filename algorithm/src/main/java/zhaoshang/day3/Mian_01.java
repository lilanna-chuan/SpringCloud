package zhaoshang.day3;

import java.util.Scanner;

public class Mian_01 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        String s=in.next();
        int count1=n-s.replace("(","").length();
        int count2=n-s.replace(")","").length();
        int count3=n-s.replace("[","").length();
        int count4=n-s.replace("]","").length();
        int x=count1;
        int xc=count2-count1;
        if(count1>count2){
            x=count2;
            xc=count1-count2;
        }
        for(int i=0;i<x;i++){

        }

        if(count1>count2){
            for(int i=0;i<count2;i++){

            }
        }
        String[] arr=s.split("");

        System.out.println(check(s));
    }

    public static boolean check(String str){
        while(check1(str)){
            str=str.substring(1,str.length()-1);
            if(str.equals("")){
                return true;
            }
        }
        return false;
    }
    public static boolean check1(String str){
        int length=str.length();
        boolean b1=str.substring(0,1).equals("(") && str.substring(length-1,length).equals(")");
        boolean b2=str.substring(0,1).equals("[") && str.substring(length-1,length).equals("]");
        return b1||b2;
    }
}
