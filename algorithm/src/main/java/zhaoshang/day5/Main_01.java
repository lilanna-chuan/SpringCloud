package zhaoshang.day5;

import java.util.Scanner;

public class Main_01 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int pre=in.nextInt();
        int sum=1;
        int n=pre/3;
        int m=pre%3;
        if(m==1){
            m=4;
            n--;
        }else if(m==0){
            m=1;
        }
        for(int i=0;i<n;i++){
            sum*=3;
        }
        sum*=m;
        System.out.println(sum);
    }
}
