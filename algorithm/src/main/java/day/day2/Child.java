package day.day2;

/**
 * @ClassName Child
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/3/30 15:44
 * @Version 1.0
 */
public class Child extends Person{
    public String grade;
    public static void main(String[] args){
        Person p = new Child();
        Derived derived=new Derived();
        System.out.println(p.name);
    }
}