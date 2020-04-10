package day.day10;

/**
 * @ClassName Solution
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/9 15:06
 * @Version 1.0
 */
public class Solution {

    public String convert(String s, int numRows) {
        if(numRows<=1){
            return s;
        }

        String[] arr=s.split("");

        String[][] tem=new String[numRows][s.length()];
        for(int x=0;x<numRows;x++){
            for(int y=0;y<s.length();y++){
                tem[x][y]="";
            }
        }
        int i=0;
        int j=0;
        int temp=0;
        for(int k=0;k<arr.length;k++){
            tem[i][j]=arr[k];
            if(i==0){
                temp=j;
            }
            if(j==temp && i<numRows-1){
                i++;
            }else {
                i--;
                j++;
            }
        }
        StringBuffer buf=new StringBuffer();
        for(int x=0;x<numRows;x++){
            for(int y=0;y<s.length();y++){
                buf.append(tem[x][y]);
            }
        }
        return  buf.toString();
    }

    public static void main(String[] args) {
        Solution solution= new Solution();
        System.out.println(solution.myAtoi("   -42"));
        //System.out.println(solution.convert("LEETCODEISHIRING",3));
    }


    public int reverse(int x) {
        boolean b=false;
        if(x<0){
            x=-x;
            b=true;
        }
        String s=x+"";
        String [] arr=s.split("");

        StringBuffer buf=new StringBuffer();
        for(int i=arr.length-1;i>=0;i--){
            buf.append(arr[i]);
        }
        int result=0;
        try{
            result=Integer.parseInt(buf.toString());
        }
        catch (Exception e){
            result=0;
        }
        if(b){
            result=-result;
        }
        return result;

    }

    public int reverse2(int x){
        long n=0;
        while(x!=0){
            n=n*10+x%10;
            x=x/10;
        }

        if(n==(int)n){
            return (int)n;
        }else {
            return 0;
        }
    }

    public int myAtoi(String str) {

        str=str.trim();
        if(str.isEmpty()){
            return 0;
        }
        String[] temp=str.split(" ");
        char[] arr=temp[0].toCharArray();
        boolean b=false;

        StringBuffer buf=new StringBuffer();
        if(arr[0]=='+'){
            b=false;
        }else if(arr[0]=='-'){
            b=true;
        }else if(arr[0]>=48 && arr[0]<=57){
            buf.append(arr[0]+"");
        }else {
            return 0;
        }
        for(int i=1;i<arr.length;i++){
            if(arr[i]<48 || arr[i]>57){
                break;
            }
            buf.append(arr[i]+"");
        }
        if(buf.length()==0){
            return 0;
        }
        long l=0;
        try{
             l=Long.parseLong(buf.toString());
        }catch (Exception e){
            return 0;
        }
        if(b){
            l=-l;
        }
        int result=(int)l;
        if(result==l){
            return result;
        }else if(b){
            return Integer.MIN_VALUE;
        }else {
            return Integer.MAX_VALUE;
        }

    }
}
