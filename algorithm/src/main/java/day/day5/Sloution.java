package day.day5;

/**
 * @ClassName Sloution
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/3 13:25
 * @Version 1.0
 */

/**
 * 旋转字符串
 */
public class Sloution {

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
    }
}
