package zhaoshang.day2;

import java.util.Scanner;

/**
 * @ClassName Main_02
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/4 13:35
 * @Version 1.0
 */
public class Main_02 {

    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int n=in.nextInt();
        int[] arr=new int[n];
        int sum=0;
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
            sum+=arr[i];
        }
        int pre=sum/n;
        int count=0;
        for(int i=0;i<n;i++){
            int temp=pre-arr[i];
            if(temp>0){
                if(temp%2!=0){
                    System.out.println(-1);
                    return;
                }else {
                    count+=temp/2;
                }
            }
        }
        System.out.println(count);
    }
}
