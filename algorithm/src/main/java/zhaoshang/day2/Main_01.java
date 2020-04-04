package zhaoshang.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName Main_01
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/4 12:03
 * @Version 1.0
 */
public class Main_01 {

    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        String s1=in.next();
        String s2=in.next();

        int count=0;
        List<String> list=new ArrayList<>();
        for(int i=0;i<=s1.length();i++){
            for(int j=i+1;j<=s1.length();j++){
                String temp=s1.substring(i,j);
                int tempCount=s2.length()-s2.replace(temp,"").length();
                if(tempCount>=count){
                    count=tempCount;
                    list.add(s1.substring(i,j));
                }
            }
        }
        Collections.sort(list);
        for(String str:list){
            if(str.length()==count){
                System.out.println(str);
            }
        }
    }
}
