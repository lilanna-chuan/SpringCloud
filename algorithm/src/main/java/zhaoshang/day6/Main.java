package zhaoshang.day6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        while(in.hasNextLine()){
            String[] str=in.nextLine().split(" ");
            int arr[]=new int[str.length];
            int max=0;
            for(int i=0;i<str.length;i++){
                arr[i]=Integer.parseInt(str[i]);
            }

            for(int i=0;i<arr.length;i++){
                for( int j=i;j<arr.length;j++){
                    int temp=arr[j]-arr[i];
                    if(temp>max){
                        max=temp;
                    }
                }
            }

            System.out.println(max);
        }
    }
}
