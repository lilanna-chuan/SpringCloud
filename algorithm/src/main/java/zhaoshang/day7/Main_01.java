package zhaoshang.day7;

import java.util.*;

public class Main_01 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n =in.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        Set<List<Integer>> sets=new HashSet<>();
        List<Integer> list=new ArrayList<>();
        help(0,0,list,sets,arr);
        System.out.println(sets.size());

    }
    public static void help(int sum ,int index,List<Integer> list,Set<List<Integer>>  sets,int[] arr){
        if(index==arr.length){
            return;
        }
        if(sum==24){
            sets.add(list);
            return;
        }
        help(sum,index+1,list,sets,arr);
        list.add(arr[index]);
        help(sum+arr[index],index+1,list,sets,arr);
    }
}
