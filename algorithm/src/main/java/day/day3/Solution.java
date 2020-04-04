package day.day3;

/**
 * @ClassName Solution
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/2 19:12
 * @Version 1.0
 */
public class Solution {

    public static void main1(String args[]) {
        int a=17^6;
        System.out.println(a);
    }
    public static void main(String[] args) {
        String a = new String("myString");
        String b = "myString";
        String c = "my" + "String";
        String d = c;
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b == c);
        System.out.println(b == d);
    }
}
