package day.day2;

/**
 * @ClassName Base
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/3/30 14:22
 * @Version 1.0
 */
public class Base {

    public void methodOne()
    {
        System.out.print("A");
        methodTwo();
    }

    public void methodTwo()
    {
        System.out.print("B");
    }
}
