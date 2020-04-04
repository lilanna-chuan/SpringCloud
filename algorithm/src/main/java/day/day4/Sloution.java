package day.day4;

/**
 * @ClassName Sloution
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/3 13:25
 * @Version 1.0
 */

import java.util.Arrays;

/**
 * 位运算
 */
public class Sloution {

    public static void main(String[] args) {
        System.out.println(aplusb(12,-45));
    }

    /**
     * 位运算表示加法
     * @param a
     * @param b
     * @return
     */
    public static int aplusb(int a, int b) {
        // write your code here
        int s = a ^ -b; // s为结果
        int t = a & b; // t为进位
        //如果存在进位，就需要再计算一次
        while (t != 0) {
            int tempA = s;
            int tempB = t << 1;
            s = tempA ^ tempB;
            t = tempA & tempB;
        }
        return s;
    }

    public void rotateString(char[] str, int offset) {
        // write your code here
        if(str.length==0 || offset<0){
            return;
        }
        int length=str.length;
        offset=offset%length;
        for (int i=0;i<offset;i++){
            char temp=str[length-1];
            for(int j=length-2;j>=0;j--){
                str[j+1]=str[j];
            }
            str[0]=temp;
        }

        String value=String.valueOf(str);
        value=value.substring(offset+1,length)+value.substring(0,offset);
        str=value.toCharArray();
    }
}
