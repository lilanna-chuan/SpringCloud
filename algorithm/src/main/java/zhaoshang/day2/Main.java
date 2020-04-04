package zhaoshang.day2;

import java.util.Scanner;

/**
 * @ClassName Main
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/4 11:18
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        String s1=in.next();
        String s2=in.next();
        while(!s1.equals("")){
            String temp=s1.substring(0,1);
            s1=s1.replace(temp,"");
            s2=s2.replace(temp,"");
            if(s1.length()!=s2.length()){
                System.out.println(false);
                return;
            }
        }
        if(s2.equals("")){
            System.out.println(true);
        }else {
            System.out.println(false);
        }

    }
}
