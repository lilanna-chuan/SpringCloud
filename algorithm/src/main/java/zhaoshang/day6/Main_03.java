package zhaoshang.day6;

import java.util.Scanner;

public class Main_03 {

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        System.out.println(help(n));

    }
    public static int help(int n){
        if(n==1){
            return 1;
        }else if(n==2){
            return 2;
        }else {
            return help(n-1)+help(n-2);
        }
    }
}
