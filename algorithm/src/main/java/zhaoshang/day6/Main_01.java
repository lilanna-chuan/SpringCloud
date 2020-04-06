package zhaoshang.day6;

import java.util.Scanner;

public class Main_01 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        while(in.hasNextLine()){
            String[] str=in.nextLine().split(" ");
            long arr[]=new long[str.length];
            for(int i=0;i<str.length;i++){
                arr[i]=Long.parseLong(str[i]);
            }
            int n=in.nextInt();
            int k=1;
            while(k<n){
                int sum=0;
                for(int i=0;i<arr.length;i++){
                    long temp=arr[i]/k;
                    if(arr[i]%k>0){
                        temp++;
                    }
                    sum+=temp;
                }
                if(sum>n){
                    k++;
                }else{
                    System.out.println(k);
                    return;
                }
            }
        }
    }
}
