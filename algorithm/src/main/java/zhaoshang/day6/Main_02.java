package zhaoshang.day6;

import java.util.Scanner;

public class Main_02 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        String str=in.next();
        String[] arr=str.split("");
        int left=0;
        int right=0;
        String leftStr="";
        String rightStr="";
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals("C")){
              int c=leftStr.length()-leftStr.replace("D","").length();
              left+=c;

            }
            leftStr+=arr[i];
            if(arr[i].equals("D")){
                int c=rightStr.length()-rightStr.replace("C","").length();
                right+=c;
            }
            rightStr+=arr[i];
        }
        if(left<right){
            System.out.println(left);
        }else {
            System.out.println(right);
        }
    }
}
