package zhaoshang.day3;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        long d=in.nextLong();
        long t=in.nextLong();
        long m=in.nextLong();
        int n=0;
        while(n<t){
            long sum=n+m*(t-n);
            if(sum>d){
                n++;
            }else if(sum==d){
                System.out.println("Possible");
                break;
            }else if(sum<d){
                System.out.println("Impossible");
                break;
            }
        }
    }
}
