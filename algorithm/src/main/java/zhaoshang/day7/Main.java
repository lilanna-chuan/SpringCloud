package zhaoshang.day7;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str=in.next();

        String temp=str.replace("*","");
        int n=str.length()-temp.length();
        StringBuffer stringBuffer=new StringBuffer();
        for(int i=0;i<n;i++){
            stringBuffer.append("*");
        }
        System.out.println(stringBuffer.toString()+temp);
    }
}
