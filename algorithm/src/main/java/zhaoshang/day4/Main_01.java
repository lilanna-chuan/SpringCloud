package zhaoshang.day4;

import java.util.Arrays;
import java.util.Scanner;

public class Main_01 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        while(in.hasNextLine()){
            String[] temp=in.nextLine().split(" ");
            int[] arr=new int[temp.length];
            for(int i=0;i<arr.length;i++){
                arr[i]=Integer.parseInt(temp[i]);
            }
            Arrays.sort(arr);
            int limit=in.nextInt();
            int count=0;
            int star=0;
            int end=arr.length-1;
            while(star<=end){

                int sum=arr[star]+arr[end];
                if(sum<=limit){
                    star++;
                }
                end--;
                count++;
            }
            System.out.println(count);
            break;
        }
    }
}
