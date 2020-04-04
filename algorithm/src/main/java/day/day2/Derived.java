package day.day2;

/**
 * @ClassName Derived
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/3/30 14:23
 * @Version 1.0
 */
public class Derived extends Base {
    public void methodOne()
    {
        super.methodOne();
        System.out.print("C");
    }

    public void methodTwo()
    {
        super.methodTwo();
        System.out.print("D");
    }

    public static void main(String[] args) {
        Base b=new Derived();
        b.methodOne();
    }
}