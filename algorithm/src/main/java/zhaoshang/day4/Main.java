package zhaoshang.day4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE==Math.abs(Integer.MIN_VALUE));
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        if(n==1){
            System.out.println(1);
        }else if(n>1){
            int count=n*(n-1)/2+n+1;
            System.out.println(count);
        }
    }
}
